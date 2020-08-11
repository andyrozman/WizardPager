package com.atech.android.library.wizardpager.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.fragment.app.Fragment;

import com.atech.android.library.wizardpager.util.WizardPagesUtil;
import com.tech.freak.wizardpager.R;
import com.tech.freak.wizardpager.model.Page;
import com.tech.freak.wizardpager.ui.PageFragmentCallbacks;

public class DisplayTextFragment extends Fragment {
    private static final String ARG_KEY = "key";
    private static final String ARG_DISPLAY_TEXT_ID = "displayTextId";
    private static final String ARG_DISPLAY_TEXT_STYLE = "displayTextStyle";

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private Page mPage;

    @StringRes
    private int displayTextId;

    @StyleRes
    private int displayTextStyle;

    protected TextView displayText;

    private DisplayTextFragment() {
    }

    public static DisplayTextFragment create(String key, @StringRes int displayTextId, @StyleRes int displayTextStyle) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);
        args.putInt(ARG_DISPLAY_TEXT_ID, displayTextId);
        args.putInt(ARG_DISPLAY_TEXT_STYLE, displayTextStyle);

        DisplayTextFragment f = new DisplayTextFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        displayTextId = args.getInt(ARG_DISPLAY_TEXT_ID);
        displayTextStyle = args.getInt(ARG_DISPLAY_TEXT_STYLE);
        mPage = mCallbacks.onGetPage(mKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page_display_text,
                container, false);
        WizardPagesUtil.setTitle(mPage, rootView);

        displayText = rootView.findViewById(R.id.pageDisplay_textView);
        displayText.setText(displayTextId);
        displayText.setTextAppearance(displayTextStyle);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof PageFragmentCallbacks)) {
            throw new ClassCastException(
                    "Activity must implement PageFragmentCallbacks");
        }

        mCallbacks = (PageFragmentCallbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
    }

}

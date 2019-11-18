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
    protected static final String ARG_KEY = "key";

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private Page mPage;

    @StringRes
    int displayTextId;

    @StyleRes
    int displayTextStyle;

    protected TextView displayText;

    public static DisplayTextFragment create(String key, @StringRes int displayTextId, @StyleRes int displayTextStyle) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        DisplayTextFragment f = new DisplayTextFragment();
        f.setArguments(args);
        f.setDisplayTextId(displayTextId);
        f.setDisplayTextStyle(displayTextStyle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = mCallbacks.onGetPage(mKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page_display_text,
                container, false);
        WizardPagesUtil.setTitle(mPage, rootView);

        displayText = (TextView) rootView.findViewById(R.id.pageDisplay_textView);
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


    public int getDisplayTextId() {
        return this.displayTextId;
    }

    public void setDisplayTextId(int displayTextId) {
        this.displayTextId = displayTextId;
    }


    public int getDisplayTextStyle() {
        return displayTextStyle;
    }

    public void setDisplayTextStyle(int displayTextStyle) {
        this.displayTextStyle = displayTextStyle;
    }


}

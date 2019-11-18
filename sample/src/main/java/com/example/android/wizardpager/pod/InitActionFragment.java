package com.example.android.wizardpager.pod;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.atech.android.library.wizardpager.util.WizardPagesUtil;
import com.example.android.wizardpager.R;
import com.tech.freak.wizardpager.model.Page;
import com.tech.freak.wizardpager.ui.PageFragmentCallbacks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TechFreak on 04/09/2014.
 */
public class InitActionFragment extends Fragment {
    private static final String ARG_KEY = "key";

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private InitActionPage mPage;

    ProgressBar progressBar;

    PodInitActionType podInitActionType;
    List<PodInitActionType> children;
    Map<PodInitActionType, CheckBox> mapCheckBoxes;

    public static InitActionFragment create(String key, PodInitActionType podInitActionType) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        InitActionFragment fragment = new InitActionFragment();
        fragment.setArguments(args);
        fragment.setPodInitActionType(podInitActionType);
        return fragment;
    }

    public InitActionFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = (InitActionPage) mCallbacks.onGetPage(mKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.omnipod_initpod_init_action, container, false);
        WizardPagesUtil.setTitle(mPage, rootView);

        progressBar = rootView.findViewById(R.id.initAction_progressBar);


        LinearLayout linearLayout = rootView.findViewById(R.id.initAction_ItemsHolder);

//        CheckBox checkBox1 = new CheckBox(getContext());
//        checkBox1.setText("Test checkbox");
//
//        linearLayout.addView(checkBox1);

        children = podInitActionType.getChildren();
        mapCheckBoxes = new HashMap<>();

        for (PodInitActionType child : children) {

            CheckBox checkBox1 = new CheckBox(getContext());
            checkBox1.setText(child.getResourceId());
            //checkBox1.setEnabled(false);
            checkBox1.setClickable(false);
            checkBox1.setTextAppearance(R.style.WizardPagePodContent);

            linearLayout.addView(checkBox1);

            mapCheckBoxes.put(child, checkBox1);
        }


        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof PageFragmentCallbacks)) {
            throw new ClassCastException("Activity must implement PageFragmentCallbacks");
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

        // In a future update to the support library, this should override setUserVisibleHint
        // instead of setMenuVisibility.

    }

    public PodInitActionType getPodInitActionType() {
        return podInitActionType;
    }


    public void setPodInitActionType(PodInitActionType podInitActionType) {
        this.podInitActionType = podInitActionType;


//        new AsyncTask<Void, Void, String>() {
//
//            protected void onPreExecute() {
//                //progressBar.setVisibility(View.VISIBLE);
//            }
//
//            ;
//
//            @Override
//            protected String doInBackground(Void... params) {
//
//                SystemClock.sleep(3000);
//                mPage.setActionCompleted();
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                super.onPostExecute(result);
//
//                System.out.println("onPostExecute: " + result);
//
////                progressBar.setVisibility(View.GONE);
//            }
//        }.execute();
//

//        new Thread(() -> {
//
//            SystemClock.sleep(3000);
//            mPage.setActionCompleted();
//
//        }).start();


    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            System.out.println("ACTION: Visible");

            new AsyncTask<Void, Void, String>() {

                protected void onPreExecute() {
                    //progressBar.setVisibility(View.VISIBLE);
                }

                ;

                @Override
                protected String doInBackground(Void... params) {

                    SystemClock.sleep(5000);
                    mPage.setActionCompleted(true);

                    System.out.println("ACTION: doInBackground Finished: ");


                    return "Test";
                }

                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);

                    System.out.println("ACTION: onPostExecute: " + result);

                    boolean isOk = true;

                    for (PodInitActionType actionType : mapCheckBoxes.keySet()) {
                        mapCheckBoxes.get(actionType).setChecked(true);
                        mapCheckBoxes.get(actionType).setTextColor(isOk ? Color.rgb(0, 255, 0) : Color.rgb(255, 0, 0));
                    }

                    progressBar.setVisibility(View.GONE);

                    mPage.getData().putString(Page.SIMPLE_DATA_KEY, "ddd");
                    mPage.notifyDataChanged();
                }
            }.execute();

        } else {
            System.out.println("ACTION: Not visible");
        }
    }
}

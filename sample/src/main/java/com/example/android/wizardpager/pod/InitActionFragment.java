package com.example.android.wizardpager.pod;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.android.wizardpager.R;
import com.example.android.wizardpager.pages.CustomerInfoPage;
import com.tech.freak.wizardpager.ui.PageFragmentCallbacks;

import java.io.IOException;
import java.util.List;

/**
 * Created by TechFreak on 04/09/2014.
 */
public class InitActionFragment extends Fragment {
    private static final String ARG_KEY = "key";

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private InitActionPage mPage;



    PodInitActionType podInitActionType;

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
        ((TextView) rootView.findViewById(android.R.id.title)).setText(mPage.getTitle());


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
    public void onStart() {
        super.onStart();
        System.out.println("ACTION: Start Init Action");
    }


    @Override
    public void onResume() {
        super.onResume();
        System.out.println("ACTION: Resume Init Action");
    }


    @Override
    public void onPause() {
        super.onPause();
        System.out.println("ACTION: Pause Init Action");
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

                    SystemClock.sleep(3000);
                    mPage.setActionCompleted();

                    return null;
                }

                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);

                    System.out.println("onPostExecute: " + result);

    //                progressBar.setVisibility(View.GONE);
                }
            }.execute();

        }
        else {
            System.out.println("ACTION: Not visible");
        }
    }
}

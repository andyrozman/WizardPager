package com.example.android.wizardpager.pod;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;

public class InitPodTask extends AsyncTask<Void, Void, String> {

    InitActionFragment initActionFragment;

    public InitPodTask(InitActionFragment initActionFragment) {

        this.initActionFragment = initActionFragment;
    }

    protected void onPreExecute() {
        initActionFragment.progressBar.setVisibility(View.VISIBLE);
        initActionFragment.errorView.setVisibility(View.GONE);
    }

    @Override
    protected String doInBackground(Void... params) {

        SystemClock.sleep(3000);
        initActionFragment.returnInitTaskStatus(PodInitActionType.PairAndPrimeWizardStep, false, "This is error with pinti process. You can retry or you can cancel.");

        return "OK";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        initActionFragment.actionOnReceiveResponse(result);
    }


}

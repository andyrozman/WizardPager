package com.example.android.wizardpager.pod;

public interface PodInitReceiver {

    void returnInitTaskStatus(PodInitActionType podInitActionType, boolean isSuccess, String errorMessage);

}

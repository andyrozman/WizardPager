package com.example.android.wizardpager.pod;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.tech.freak.wizardpager.model.ModelCallbacks;
import com.tech.freak.wizardpager.model.Page;
import com.tech.freak.wizardpager.model.ReviewItem;

import java.util.ArrayList;


/**
 * A page asking for a name and an email.
 */
public class InitActionPage extends Page {
    public static final String NAME_DATA_KEY = "name";
    public static final String EMAIL_DATA_KEY = "email";

    private PodInitActionType podInitActionType;

    private boolean actionCompleted = false;

    public InitActionPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    public InitActionPage(ModelCallbacks callbacks, @StringRes int titleId, PodInitActionType podInitActionType) {
        super(callbacks, titleId);
        this.podInitActionType = podInitActionType;
    }

    @Override
    public Fragment createFragment() {
        return InitActionFragment.create(getKey(), this.podInitActionType);
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
    }

    @Override
    public boolean isCompleted() {
        return actionCompleted;
    }

    public void setActionCompleted() {
        this.actionCompleted = true;
    }
}

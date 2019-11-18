package com.example.android.wizardpager.pod;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

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
    private boolean actionSuccess = false;

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
        System.out.println("ACTION: Page.isCompleted " + actionCompleted);
        return actionCompleted;
    }

    public void setActionCompleted(boolean success) {
        this.actionCompleted = true;
        this.actionSuccess = success;
    }

    /**
     * This is used just if we want to override default behavior (for example when we enter Page we want prevent any action, until something happens.
     *
     * @return
     */
    public boolean isBackActionPossible() {
        return actionCompleted;
    }

    /**
     * This is used just if we want to override default behavior (for example when we enter Page we want prevent any action, until something happens.
     *
     * @return
     */
    public boolean isNextActionPossible() {
        return actionSuccess;
    }

}

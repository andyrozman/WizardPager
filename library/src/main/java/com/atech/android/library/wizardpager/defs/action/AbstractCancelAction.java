package com.atech.android.library.wizardpager.defs.action;

import androidx.fragment.app.FragmentManager;

public abstract class AbstractCancelAction implements CancelActionInterface {

    protected String cancelActionText = "Canceled";
    protected FragmentManager fragmentManager;

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public abstract void execute(String cancelReason);

    public String getCancelActionText() {
        return this.cancelActionText;
    }

    public FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

}

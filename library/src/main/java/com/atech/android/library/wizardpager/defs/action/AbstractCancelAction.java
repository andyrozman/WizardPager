package com.atech.android.library.wizardpager.defs.action;

import androidx.fragment.app.FragmentManager;

public abstract class AbstractCancelAction {

    protected String cancelActionText = "Canceled";

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    protected FragmentManager fragmentManager;

    public abstract void execute(String cancelReason);

    public String getCancelActionText() {
        return this.cancelActionText;
    }

}

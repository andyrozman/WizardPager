package com.atech.android.library.wizardpager.defs.action;

import androidx.fragment.app.FragmentManager;

public abstract class AbstractFinishAction {

    protected String finishActionText = "Finished_OK";

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    protected FragmentManager fragmentManager;

    public abstract void execute();

    public String getFinishActionText() {
        return this.finishActionText;
    }

}

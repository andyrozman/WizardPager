package com.atech.android.library.wizardpager.defs.action;

import androidx.fragment.app.FragmentManager;

public abstract class AbstractFinishAction implements FinishActionInterface {

    protected String finishActionText = "Finished_OK";
    protected FragmentManager fragmentManager;

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public abstract void execute();

    public String getFinishActionText() {
        return this.finishActionText;
    }

    public FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

}

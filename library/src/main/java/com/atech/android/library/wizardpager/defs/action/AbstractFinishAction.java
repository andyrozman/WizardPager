package com.atech.android.library.wizardpager.defs.action;

import androidx.fragment.app.FragmentManager;

public abstract class AbstractFinishAction {

    protected String finishActionText = "finished_ok";
    protected FragmentManager fragmentManager;

    public abstract void execute();

    public String getFinishActionText() {
        return this.finishActionText;
    }

}

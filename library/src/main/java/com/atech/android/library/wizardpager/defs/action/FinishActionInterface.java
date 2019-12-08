package com.atech.android.library.wizardpager.defs.action;

import androidx.fragment.app.FragmentManager;

public interface FinishActionInterface {

    void setFragmentManager(FragmentManager fragmentManager);

    FragmentManager getFragmentManager();

    void execute();

    String getFinishActionText();
}

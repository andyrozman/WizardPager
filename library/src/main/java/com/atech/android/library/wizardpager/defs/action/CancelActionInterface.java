package com.atech.android.library.wizardpager.defs.action;

import androidx.fragment.app.FragmentManager;

public interface CancelActionInterface {

    void setFragmentManager(FragmentManager fragmentManager);

    FragmentManager getFragmentManager();

    void execute(String cancelReason);

    String getCancelActionText();

}

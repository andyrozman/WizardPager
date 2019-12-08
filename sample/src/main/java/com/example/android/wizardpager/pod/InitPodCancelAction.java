package com.example.android.wizardpager.pod;

import androidx.fragment.app.FragmentManager;

import com.atech.android.library.wizardpager.defs.action.AbstractCancelAction;
import com.atech.android.library.wizardpager.defs.action.CancelActionInterface;

public class InitPodCancelAction extends AbstractCancelAction implements CancelActionInterface {


    @Override
    public void execute(String cancelReason) {
        if (cancelReason != null && cancelReason.trim().length() > 0) {
            this.cancelActionText = cancelReason;
        }

        System.out.println("InitPodCancelAction: " + cancelReason);

        if (this.cancelActionText.equals("Cancel")) {
            // TODO
            // remove pod from SP

            // do refresh of tab
        }


    }
}

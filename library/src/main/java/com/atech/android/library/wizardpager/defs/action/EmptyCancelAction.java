package com.atech.android.library.wizardpager.defs.action;

public class EmptyCancelAction extends AbstractCancelAction {
    @Override
    public void execute(String cancelReason) {
        if (cancelReason != null && cancelReason.trim().length() > 0) {
            this.cancelActionText = cancelReason;
        }
    }
}

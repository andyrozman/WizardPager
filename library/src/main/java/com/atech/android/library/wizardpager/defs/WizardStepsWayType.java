package com.atech.android.library.wizardpager.defs;

public enum WizardStepsWayType {

    PreviousNext, // wizard can go back to previous entry
    CancelNext; // wizard can't go back, but it can cancel execution (need to set cancelReason on page)

}

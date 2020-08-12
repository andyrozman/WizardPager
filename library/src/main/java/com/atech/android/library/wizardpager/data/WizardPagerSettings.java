package com.atech.android.library.wizardpager.data;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.atech.android.library.wizardpager.defs.WizardStepsWayType;
import com.atech.android.library.wizardpager.defs.action.AbstractCancelAction;
import com.atech.android.library.wizardpager.defs.action.AbstractFinishAction;
import com.atech.android.library.wizardpager.defs.action.CancelActionInterface;
import com.atech.android.library.wizardpager.defs.action.FinishActionInterface;
import com.tech.freak.wizardpager.R;

public class WizardPagerSettings {

    private WizardStepsWayType wizardStepWay = WizardStepsWayType.PreviousNext;
    private int pagerAdapterBehavior = FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT;

    private FinishActionInterface finishAction;
    private CancelActionInterface cancelAction;

    private @StringRes
    int finishStringResourceId;
    private @StringRes
    int backStringResourceId;
    private @StringRes
    int nextStringResourceId = R.string.next;

    private @DrawableRes
    int finishButtonBackground = R.drawable.finish_background;
    private @DrawableRes
    int nextButtonBackground = R.drawable.selectable_item_background;
    private @StyleRes
    int theme = 0;

    private @StyleRes
    int finishTextAppearance = R.style.TextAppearanceFinish;


    public WizardStepsWayType getWizardStepsWayType() {
        return this.wizardStepWay;
    }


    public void setWizardStepsWayType(WizardStepsWayType wizardStepWay) {
        this.wizardStepWay = wizardStepWay;
    }

    public FinishActionInterface getFinishAction() {
        return finishAction;
    }

    public void setFinishAction(FinishActionInterface finishAction) {
        this.finishAction = finishAction;
    }

    public int getFinishButtonBackground() {
        return finishButtonBackground;
    }

    public void setFinishButtonBackground(int finishButtonBackground) {
        this.finishButtonBackground = finishButtonBackground;
    }

    public int getNextButtonBackground() {
        return nextButtonBackground;
    }

    public void setNextButtonBackground(int nextButtonBackground) {
        this.nextButtonBackground = nextButtonBackground;
    }

    public int getFinishTextAppearance() {
        return finishTextAppearance;
    }

    public void setFinishTextAppearance(int finishTextAppearance) {
        this.finishTextAppearance = finishTextAppearance;
    }

    public int getFinishStringResourceId() {
        return finishStringResourceId;
    }

    public void setFinishStringResourceId(int finishStringResourceId) {
        this.finishStringResourceId = finishStringResourceId;
    }

    public int getBackStringResourceId() {
        return backStringResourceId;
    }

    public void setBackStringResourceId(int backStringResourceId) {
        this.backStringResourceId = backStringResourceId;
    }

    public int getNextStringResourceId() {
        return nextStringResourceId;
    }

    public void setNextStringResourceId(int nextStringResourceId) {
        this.nextStringResourceId = nextStringResourceId;
    }

    public CancelActionInterface getCancelAction() {
        return cancelAction;
    }

    public void setCancelAction(CancelActionInterface cancelAction) {
        this.cancelAction = cancelAction;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public int getPagerAdapterBehavior() {
        return pagerAdapterBehavior;
    }

    /**
     * @param pagerAdapterBehavior the behavior for the FragmentStatePagerAdapter; defaults to
     *                             FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT
     */
    public void setPagerAdapterBehavior(int pagerAdapterBehavior) {
        this.pagerAdapterBehavior = pagerAdapterBehavior;
    }
}

package com.atech.android.library.wizardpager;

import com.atech.android.library.wizardpager.data.WizardPagerSettings;
import com.tech.freak.wizardpager.model.AbstractWizardModel;

public class WizardPagerContext {


    private static final WizardPagerContext instance = new WizardPagerContext();

    private AbstractWizardModel wizardModel;
    private WizardPagerSettings pagerSettings;
    private Object completeMessage;

    public static WizardPagerContext getInstance() {
        return instance;
    }

    public void clearContext() {
        this.pagerSettings = null;
        this.wizardModel = null;
        this.completeMessage = null;
    }


    public AbstractWizardModel getWizardModel() {
        return wizardModel;
    }

    public void setWizardModel(AbstractWizardModel wizardModel) {
        this.wizardModel = wizardModel;
    }

    public WizardPagerSettings getPagerSettings() {
        return pagerSettings;
    }

    public void setPagerSettings(WizardPagerSettings pagerSettings) {
        this.pagerSettings = pagerSettings;
    }

    public void setCompleteMessage(Object completeMessage) {
        this.completeMessage = completeMessage;
    }

    public Object getCompleteMessage() {
        return completeMessage;
    }
}

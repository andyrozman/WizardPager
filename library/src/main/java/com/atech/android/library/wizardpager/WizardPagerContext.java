package com.atech.android.library.wizardpager;

import com.atech.android.library.wizardpager.data.WizardPagerSettings;
import com.tech.freak.wizardpager.model.AbstractWizardModel;

public class WizardPagerContext {


    private static final WizardPagerContext instance = new WizardPagerContext();

    private AbstractWizardModel wizardModel;
    private WizardPagerSettings pagerSettings;

    public static WizardPagerContext getInstance() {
        return instance;
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
}

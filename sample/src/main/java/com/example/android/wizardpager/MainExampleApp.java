package com.example.android.wizardpager;

import android.app.Application;
import android.content.res.Resources;

import com.atech.android.library.wizardpager.WizardPagerActivity;
import com.atech.android.library.wizardpager.data.WizardPagerSettings;
import com.atech.android.library.wizardpager.defs.WizardStepsWayType;

public class MainExampleApp extends Application {


    private static MainExampleApp sInstance;
    public static Resources sResources;

    int sampleUse = 2;

    public MainExampleApp() {







    }


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sResources = getResources();
        WizardPagerSettings pagerSettings = new WizardPagerSettings();

//        mNextButton.setBackgroundResource(com.tech.freak.wizardpager.R.drawable.finish_background);
//        mNextButton.setTextAppearance(this, com.tech.freak.wizardpager.R.style.TextAppearanceFinish);
//    } else {
//        mNextButton.setText(mEditingAfterReview ? com.tech.freak.wizardpager.R.string.review
//                : com.tech.freak.wizardpager.R.string.next);
//        mNextButton
//                .setBackgroundResource(com.tech.freak.wizardpager.R.drawable.selectable_item_background);




        if (sampleUse==1) {

            // 1. original sample
            pagerSettings.setWizardStepsWayType(WizardStepsWayType.PreviousNext);
            pagerSettings.setFinishStringResourceId(R.string.finish);
            pagerSettings.setFinishButtonBackground(R.drawable.finish_background);
            pagerSettings.setNextButtonBackground(R.drawable.selectable_item_background);
            pagerSettings.setFinishTextAppearance(R.style.TextAppearanceFinish);

            WizardPagerActivity pagerActivity = new WizardPagerActivity(new SandwichWizardModel(this), pagerSettings);
            pagerActivity.getOnCloseStatus();
        } else if (sampleUse==2) {

            pagerSettings.setWizardStepsWayType(WizardStepsWayType.CancelNext);
            pagerSettings.setFinishStringResourceId(R.string.finish);
            pagerSettings.setFinishButtonBackground(R.drawable.finish_background);
            pagerSettings.setNextButtonBackground(R.drawable.selectable_item_background);

            WizardPagerActivity pagerActivity = new WizardPagerActivity(new SandwichWizardModel(this), pagerSettings);
            pagerActivity.getOnCloseStatus();
        }





    }

}

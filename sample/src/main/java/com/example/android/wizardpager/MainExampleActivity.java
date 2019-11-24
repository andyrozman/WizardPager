package com.example.android.wizardpager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.atech.android.library.wizardpager.WizardPagerActivity;
import com.atech.android.library.wizardpager.WizardPagerContext;
import com.atech.android.library.wizardpager.data.WizardPagerSettings;
import com.atech.android.library.wizardpager.defs.WizardStepsWayType;
import com.example.android.wizardpager.pod.InitPodCancelAction;
import com.example.android.wizardpager.pod.InitPodWizardModel;

public class MainExampleActivity extends FragmentActivity {

    Button button;
    int sampleUse = 2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);


        this.button = (Button) findViewById(R.id.exampleStartButton);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WizardPagerSettings pagerSettings = new WizardPagerSettings();

                System.out.println("ZZZZ: In Main Example Activity");

                pagerSettings.setTheme(R.style.AppTheme);


                if (sampleUse == 1) {

                    // 1. original sample
                    pagerSettings.setWizardStepsWayType(WizardStepsWayType.PreviousNext);
                    pagerSettings.setFinishStringResourceId(R.string.finish);
                    pagerSettings.setFinishButtonBackground(R.drawable.finish_background);
                    pagerSettings.setNextButtonBackground(R.drawable.selectable_item_background);
                    pagerSettings.setFinishTextAppearance(R.style.TextAppearanceFinish);

                    //WizardPagerActivity pagerActivity = new WizardPagerActivity(new SandwichWizardModel(this), pagerSettings);
                    //pagerActivity.getOnCloseStatus();
                } else if (sampleUse == 2) {


                    pagerSettings.setWizardStepsWayType(WizardStepsWayType.CancelNext);
                    pagerSettings.setFinishStringResourceId(R.string.common_close);
                    pagerSettings.setFinishButtonBackground(R.drawable.finish_background);
                    pagerSettings.setNextButtonBackground(R.drawable.selectable_item_background);
                    pagerSettings.setBackStringResourceId(R.string.common_back);
                    pagerSettings.setCancelAction(new InitPodCancelAction());


                    WizardPagerContext.getInstance().setPagerSettings(pagerSettings);
                    WizardPagerContext.getInstance().setWizardModel(new InitPodWizardModel(getApplicationContext()));

                    //WizardPagerActivity pagerActivity = new WizardPagerActivity(new InitPodWizardModel(this), pagerSettings);
                    //pagerActivity.getOnCloseStatus();
                }

                Intent myIntent = new Intent(MainExampleActivity.this, WizardPagerActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainExampleActivity.this.startActivity(myIntent);

            }
        });
    }


}

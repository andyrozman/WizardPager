package com.example.android.wizardpager;

import android.app.Application;
import android.content.res.Resources;

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


    }

}

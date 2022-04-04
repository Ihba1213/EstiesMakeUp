package com.esties.android;

import android.app.Application;

public class MyApp extends Application {
    public static MyApp instance;
    public String getLanguageType() {
        return languageType;
    }

    public void setLanguageType(String languageType) {
        this.languageType = languageType;
    }

    private String languageType;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setLanguageType("english");
    }
    public static MyApp getInstance() {
        return instance;
    }
}

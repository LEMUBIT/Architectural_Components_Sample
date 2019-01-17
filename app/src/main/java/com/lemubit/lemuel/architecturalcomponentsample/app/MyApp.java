package com.lemubit.lemuel.architecturalcomponentsample.app;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    private  Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public Context getContext() {
        return getApplicationContext();
    }
}

package com.canyourunit.vocalbrain;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by mintyguy on 23/01/16.
 */
public class VocalBrain extends Application {
    private static Context appContext;

    @Override
    public void onCreate(){
        super.onCreate();
        appContext = getApplicationContext();
        Log.d(VocalBrain.class.getName(), "onCreate");
    }
    public static Context getAppContext() {
        return appContext;
    }
    public static void setAppContext(Context applicationContext) {
        VocalBrain.appContext = applicationContext;
    }
}
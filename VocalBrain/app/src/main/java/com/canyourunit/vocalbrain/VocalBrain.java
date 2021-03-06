package com.canyourunit.vocalbrain;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.canyourunit.vocalbrain.activities.LevelSelectActivity;

/**
 * Created by mintyguy on 23/01/16.
 */
public class VocalBrain extends Application {
    private static Context appContext;
    private static boolean fermeTaYeule = false;

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

    public static boolean isFermeTaYeule() {
        return fermeTaYeule;
    }

    public static void setFermeTaYeule(boolean fermeTaYeule) {
        VocalBrain.fermeTaYeule = fermeTaYeule;
    }
}
/*
 * 
 * File: MyObserver.java
 * 
 * Copyright (C) 2015, Nuance Communications Inc. All Rights Reserved.
 * 
 */

package com.nuance.nina.observer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.nuance.nina.listener.MyConnectionListener;
import com.nuance.nina.listener.MyEndpointingListener;
import com.nuance.nina.listener.MyEnergyLevelListener;
import com.nuance.nina.listener.MyInterpretationListener;
import com.nuance.nina.listener.MyPlaybackListener;
import com.nuance.nina.listener.MyRecordingListener;
import com.nuance.nina.mmf.MMFController;
import com.nuance.nina.mmf.Observer;

/**
 * Class that registers the observers needed for the application
 *
 */
public class MyObserver{

    private MyConnectionListener connectionListener;
    private MyPlaybackListener playbackListener;
    private MyRecordingListener recordingListener;
    private MyInterpretationListener interpretationListener;
    private MyEndpointingListener endpointingListener;
    private MyEnergyLevelListener energyLevelListener;

    Observer observer = MMFController.getInstance().getObserver(); 

    public  MyObserver(AppCompatActivity activity){
        connectionListener = new MyConnectionListener(activity);
        playbackListener = new MyPlaybackListener(activity);
        recordingListener = new MyRecordingListener(activity);
        interpretationListener = new MyInterpretationListener(activity);
        endpointingListener = new MyEndpointingListener(activity);
        energyLevelListener = new MyEnergyLevelListener(activity);
    }

    public void registerListeners(){
        observer.registerConnectionListener(connectionListener);
        observer.registerPlaybackListener(playbackListener);
        observer.registerRecordingListener(recordingListener);
        observer.registerInterpretationListener(interpretationListener);
        observer.registerEndpointingListener(endpointingListener);
        observer.registerEnergyLevelListener(energyLevelListener);
    }

    public void unregisterListeners(){
        observer.unregisterConnectionListener(connectionListener);		
        observer.unregisterPlaybackListener(playbackListener);
        observer.unregisterRecordingListener(recordingListener);
        observer.unregisterInterpretationListener(interpretationListener);
        observer.unregisterEndpointingListener(endpointingListener);
        observer.unregisterEnergyLevelListener(energyLevelListener);
    }

}
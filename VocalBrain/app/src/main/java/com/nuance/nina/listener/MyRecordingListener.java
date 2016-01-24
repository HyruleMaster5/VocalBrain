/*
 * 
 * File: MyRecordingListener.java
 * 
 * Copyright (C) 2015, Nuance Communications Inc. All Rights Reserved.
 * 
 */

package com.nuance.nina.listener;

import java.text.DateFormat;
import java.util.Date;


import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.canyourunit.vocalbrain.MainActivity;
import com.nuance.nina.mmf.listeners.AudioCollected;
import com.nuance.nina.mmf.listeners.RecordingError;
import com.nuance.nina.mmf.listeners.RecordingListener;
import com.nuance.nina.mmf.listeners.RecordingStarted;
import com.nuance.nina.mmf.listeners.RecordingStopped;

/**
 * Implementation of RecordingListener
 * Handles the recording states of the application
 *
 */
public class MyRecordingListener implements RecordingListener {
	private static AppCompatActivity myActivity;
	private Context myContext;

	public MyRecordingListener(AppCompatActivity activity) {
		myActivity = activity;
		myContext = myActivity.getApplicationContext();
	}

	/**
	 * Triggered when recording results in data returned to client.
	 */
	@Override
	public void onAudioCollected(AudioCollected data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}

	/**
	 * Triggered when there is a recording error. There will be no further recording events after stopped.
	 */
	@Override
	public void onRecordingError(final RecordingError data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}

	/**
	 * Triggered when the audio started recording
	 */
	@Override
	public void onRecordingStarted(RecordingStarted data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}

	/**
	 * Triggered when the audio stopped to record. There will be no further recording events after stopped.
	 */
	@Override
	public void onRecordingStopped(final RecordingStopped data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}

	/*public void changeRecordingStatus(Views currentFragment){
		switch(currentFragment){
		case SAY:
			SayFragment.setRecording(true);
			break;
		case DICTATE:
			DictationFragment.setRecording(true);
			break;
		default:
			break;
		}
	}
	
	public void changeDoneRecordingStatus(Views currentFragment){
		switch(currentFragment){
		case SAY:
			SayFragment.setDoneRecording(true);
			break;
		case DICTATE:
			DictationFragment.setDoneRecording(true);
			break;
		default:
			break;
		}
	}
	/**
	 * Method to change the button text value when the SayFragment is the current fragment displayed
	 * @param currentFragment
	 */
	/*public void changeButtonText(Views currentFragment){
		MyEnergyLevelListener.updateLevelSoundBar(0);
		switch(currentFragment){
		case SAY:
			final Button listenButton = (Button) myActivity.findViewById(R.id.listenButton);
			listenButton.setText("Listen");
			break;
		case DICTATE:
			final Button dictationButton = (Button) myActivity.findViewById(R.id.dictationButton);
			dictationButton.setText("Dictate");
			break;
		default:
			break;
		}
	}*/
}

/*
 * 
 * File: MyEndpointingListener.java
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
import com.nuance.nina.mmf.listeners.EndOfSpeech;
import com.nuance.nina.mmf.listeners.EndpointingListener;
import com.nuance.nina.mmf.listeners.StartOfSpeech;

/**
 * Implementation of EndpointingListener
 * Handles the triggers for start and end of speech
 *
 */
public class MyEndpointingListener implements EndpointingListener{
	private AppCompatActivity myActivity;
	private Context myContext;

	public  MyEndpointingListener(AppCompatActivity activity){
		myActivity = activity;
		myContext = myActivity.getApplicationContext();
	}

	/**
	 * Event triggered when the application detects that the user started to speak. Endpointing must be enabled to receive these events.
	 */
	@Override
	public void onStartOfSpeech(StartOfSpeech data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		});
	}

	/**
	 * Event triggered when the application detects that the user stopped to speak. Endpointing must be enabled to receive these events.
	 */
	@Override
	public void onEndOfSpeech(EndOfSpeech data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {	
			@Override
			public void run() {
			}
		} );
	}
	
	/*private void buttonStatus(Views currentFragment){
		switch(currentFragment){
		case SAY:
			final Button listenButton = (Button) myActivity.findViewById(R.id.listenButton);
			listenButton.setEnabled(false);
			break;
		case DICTATE:
			final Button dictationButton = (Button) myActivity.findViewById(R.id.dictationButton);
			dictationButton.setEnabled(false);
			break;
		case TYPE:
			break;
		case HINT:
			break;
		default:
			break;
		}
	}*/
}
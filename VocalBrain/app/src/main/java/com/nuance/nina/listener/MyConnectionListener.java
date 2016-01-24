/*
 * 
 * File: MyConnectionListener.java
 * 
 * Copyright (C) 2015, Nuance Communications Inc. All Rights Reserved.
 * 
 */

package com.nuance.nina.listener;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.nuance.nina.mmf.MMFController;
import com.nuance.nina.mmf.PromptType;
import com.nuance.nina.mmf.listeners.Connect;
import com.nuance.nina.mmf.listeners.ConnectError;
import com.nuance.nina.mmf.listeners.ConnectError.Reason;
import com.nuance.nina.mmf.listeners.ConnectionListener;
import com.nuance.nina.mmf.listeners.ConnectionLost;
import com.nuance.nina.mmf.listeners.Disconnect;
import com.nuance.nina.mmf.listeners.DisconnectError;

/**
 * Implementation of ConnectionListener
 * Handles the connection state of the application and triggers the events associated to the connection events
 *
 */
public class MyConnectionListener implements ConnectionListener{
	private AppCompatActivity myActivity;
	private Context myContext;

	public  MyConnectionListener(AppCompatActivity activity){
		myActivity = activity;
		myContext = myActivity.getApplicationContext();
	}

	/**
	 * Event triggered when the application is connected to Nina. The data object contains the conversation initial state.
	 */
	@Override
	public void onConnect(final Connect data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
				MMFController.getInstance().playPrompt("Welcome to Vocal Brain", PromptType.TEXT);
			}
		} );
	}

	/**
	 * Event triggered when the connetion to the server fails
	 */
	@Override
	public void onConnectError(final ConnectError data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
				if (data.reason == Reason.ILLEGAL_STATE_CONNECTED){
				}
				else{
				}
			}
		} );
	}

	/**
	 * Event triggered if the connection is lost for example due to session expiration.
	 */
	@Override
	public void onConnectionLost(final ConnectionLost data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}

	/**
	 * Connection triggered when the application is disconnected from Nina
	 */
	@Override
	public void onDisconnect(Disconnect data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}

	/**
	 * Event triggered if there is a disconnection error for example if attempting to call disconnect from the DISCONNECTED state
	 */
	@Override
	public void onDisconnectError(final DisconnectError data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {

			}
		} );
	}
}
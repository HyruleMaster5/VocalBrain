/*
 * 
 * File: MyEnergyLevelListener.java
 * 
 * Copyright (C) 2015, Nuance Communications Inc. All Rights Reserved.
 * 
 */

package com.nuance.nina.listener;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.nuance.nina.mmf.listeners.EnergyLevel;
import com.nuance.nina.mmf.listeners.EnergyLevelListener;

/**
 * Implementation of EnergyLevelListener
 * Handles the energy level of speech and audio and updates the sound bars with the audio energy level
 *
 */
public class MyEnergyLevelListener implements EnergyLevelListener{
	private static AppCompatActivity myActivity;
	public  MyEnergyLevelListener(AppCompatActivity activity){
		myActivity = activity;
	}

	/**
	 * Triggered when the user starts recording or when a prompt is playing. This event will occur many times while recording or TTS.
	 */
	@Override
	public void onEnergyLevel(final EnergyLevel data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );	
	}

	/**
	 * Method to update the sound bars that represent the audio energy level when the user is speaking or a TTS is playing
	 * @param value Represent the energy level emitted while recording or TTS playing
	 */
	/*public static void updateLevelSoundBar(int value){
		final ProgressBar levelSoundBar = (ProgressBar) myActivity.findViewById(R.id.levelSoundBar);
		levelSoundBar.setProgress(value/4);

		final ProgressBar levelSoundBar1 = (ProgressBar) myActivity.findViewById(R.id.levelSoundBar1);
		levelSoundBar1.setProgress(value/3);

		final ProgressBar levelSoundBar2 = (ProgressBar) myActivity.findViewById(R.id.levelSoundBar2);
		levelSoundBar2.setProgress(value/2);

		final ProgressBar levelSoundBar3 = (ProgressBar) myActivity.findViewById(R.id.levelSoundBar3);
		levelSoundBar3.setProgress((int) (value/1.5));

		final ProgressBar levelSoundBar4 = (ProgressBar) myActivity.findViewById(R.id.levelSoundBar4);
		levelSoundBar4.setProgress(value);

		final ProgressBar levelSoundBar5 = (ProgressBar) myActivity.findViewById(R.id.levelSoundBar5);
		levelSoundBar5.setProgress((int) (value/1.5));

		final ProgressBar levelSoundBar6 = (ProgressBar) myActivity.findViewById(R.id.levelSoundBar6);
		levelSoundBar6.setProgress(value/2);

		final ProgressBar levelSoundBar7 = (ProgressBar) myActivity.findViewById(R.id.levelSoundBar7);
		levelSoundBar7.setProgress(value/3);

		final ProgressBar levelSoundBar8 = (ProgressBar) myActivity.findViewById(R.id.levelSoundBar8);
		levelSoundBar8.setProgress(value/4);
	}*/
}
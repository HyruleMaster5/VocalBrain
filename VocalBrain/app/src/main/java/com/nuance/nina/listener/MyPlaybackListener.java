/*
 * 
 * File: MyPlaybackListener.java
 * 
 * Copyright (C) 2015, Nuance Communications Inc. All Rights Reserved.
 * 
 */

package com.nuance.nina.listener;

import java.text.DateFormat;
import java.util.Date;


import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import com.canyourunit.vocalbrain.MainActivity;
import com.nuance.nina.mmf.listeners.PlaybackError;
import com.nuance.nina.mmf.listeners.PlaybackListener;
import com.nuance.nina.mmf.listeners.PlaybackQueueEmptied;
import com.nuance.nina.mmf.listeners.PlaybackStarted;
import com.nuance.nina.mmf.listeners.PlaybackStopped;

/**
 * Implements the PlaybackListener
 * Handles the playback states of the application when audio playing events happen.
 *
 */
public class MyPlaybackListener implements PlaybackListener {
	private AppCompatActivity myActivity;

	public MyPlaybackListener(AppCompatActivity activity){
		myActivity = activity;
	}
	/**
	 * Called when there is an audio error. On error there will not be a stopped event for this audio request.
	 */
	@Override
	public void onPlaybackError(PlaybackError error) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}
	/**
	 * Called when the play queue is empty.
	 */
	@Override
	public void onPlaybackQueueEmptied(PlaybackQueueEmptied data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}

	/**
	 * Called by the event listener when TTS playback started.
	 */
	@Override
	public void onPlaybackStarted(PlaybackStarted data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}
	/**
	 * Called when audio playing is stopped normally.
	 */
	@Override
	public void onPlaybackStopped(PlaybackStopped data) {
		Handler handler = new Handler(Looper.getMainLooper()); 
		handler.post(new Runnable() {
			@Override
			public void run() {
			}
		} );
	}

	/*private void disabler(Views currentFragment){
		switch(currentFragment){
		case SAY:
			if (SayFragment.isRecording()){
				final Button listenButton = (Button) myActivity.findViewById(R.id.listenButton);
				listenButton.setText("Listen");
				SayFragment.setRecording(false);
				listenButton.setEnabled(true);
			}
			break;
		case DICTATE:
			if (DictationFragment.isRecording()){
				final Button dictationButton = (Button) myActivity.findViewById(R.id.dictationButton);
				dictationButton.setText("Dictate");
				dictationButton.setEnabled(true);
				DictationFragment.setRecording(false);
			}
			break;
		case PLAY:
			if (PlayFragment.isTTSPlaying()){
				final Button stopButton = (Button) myActivity.findViewById(R.id.stopButton);
				stopButton.setEnabled(false);
				
				EditText playText = (EditText) myActivity.findViewById(R.id.playText);
	            playText.setEnabled(true);

				final Button playButton = (Button) myActivity.findViewById(R.id.playButton);
				playButton.setEnabled(true);
				
				PlayFragment.setTTSPlaying(false);
			}
			break;
		case TYPE:
			if(TypeFragment.isTTSPlaying()){
				TypeFragment.setTTSPlaying(false);
				
				final Button sendButton = (Button) myActivity.findViewById(R.id.sendButton);
				sendButton.setEnabled(true);
				
				EditText typeText = (EditText) myActivity.findViewById(R.id.typeText);
				typeText.setEnabled(true);
			}
			break;
		case HINT:
			if(HintFragment.isTTSPlaying()){
				final Spinner hintSpinner = (Spinner) myActivity.findViewById(R.id.hintSpinner);
				hintSpinner.setEnabled(true);
			}
			break;
		default:
			break;
		}
	}*/
}

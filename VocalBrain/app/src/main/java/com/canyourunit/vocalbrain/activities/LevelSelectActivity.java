package com.canyourunit.vocalbrain.activities;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.canyourunit.vocalbrain.R;
import com.nuance.nina.listener.MyInterpretationListener;
import com.nuance.nina.mmf.MMFController;
import com.nuance.nina.observer.MyObserver;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Gabriel on 2016-01-24.
 */
public class LevelSelectActivity extends AppCompatActivity {
    private MyInterpretationListener listener;
    private MyObserver observer;
    private Timer t;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelselect);
        listener = new MyInterpretationListener(this);
        observer = new MyObserver(this);
        observer.registerListeners();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(LevelSelectActivity.class.getName(), "lbob");
        MMFController.getInstance().startListeningForRecognition();
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(t != null) {
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    Log.d(LevelSelectActivity.class.getName(), "REsume2");
                    MMFController.getInstance().stopRecordingAudio();
                }
            }, 50000);
        }
    }
}

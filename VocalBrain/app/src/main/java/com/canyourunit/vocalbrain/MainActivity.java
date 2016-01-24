package com.canyourunit.vocalbrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.media.MediaPlayer;

import com.canyourunit.vocalbrain.singleton.MyNinaConfiguration;
import com.nuance.nina.listener.MyInterpretationListener;
import com.nuance.nina.mmf.MMFController;
import com.nuance.nina.observer.MyObserver;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{
    private MyInterpretationListener listener;
    private MyObserver observer;
    private Timer t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(MainActivity.class.getName(), "onCreate");
        MyNinaConfiguration.getInstance();
        Log.d(MainActivity.class.getName(), "BOb");
        listener = new MyInterpretationListener(this);
        observer = new MyObserver(this);
        observer.registerListeners();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(MainActivity.class.getName(), "lbob");
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.d(MainActivity.class.getName(), "REsume");
                MMFController.getInstance().startListeningForRecognition();
                t = null;
            }
        }, 4000);
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(t != null) {
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    Log.d(MainActivity.class.getName(), "REsume2");
                    MMFController.getInstance().stopRecordingAudio();
                }
            }, 50000);
        }
    }
}

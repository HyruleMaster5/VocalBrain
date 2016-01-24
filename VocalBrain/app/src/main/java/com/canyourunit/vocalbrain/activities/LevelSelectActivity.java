package com.canyourunit.vocalbrain.activities;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.canyourunit.vocalbrain.R;

/**
 * Created by Gabriel on 2016-01-24.
 */
public class LevelSelectActivity extends AppCompatActivity {

    private ImageView colortraplevel;
    private ImageView wordscramblelevel;
    private AnimationDrawable microphone_animation;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelselect);

        ImageView rocketImage = (ImageView) findViewById(R.id.microphone);
        rocketImage.setBackgroundResource(R.drawable.micro_recognized_00000);
        microphone_animation = (AnimationDrawable) rocketImage.getBackground();
    }

    public void commandRecognized() {
        microphone_animation.start();
    }

    public void selectColorTrap(){

    }

    public void selectWordScramble(){

    }

}

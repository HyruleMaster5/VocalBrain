/***************************************************************************************************
 * Main activity of the minigame Color Trap
 *
 * @author: Christian Hardy-Cardinal
 * @since: 1.0.0 2016-01-23
 * *************************************************************************************************
 * Date       Author Description
 * ---------- ------ -------------------------------------------------------------------------------
 */
package com.canyourunit.vocalbrain.activities.colortrap;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.canyourunit.vocalbrain.R;
import com.canyourunit.vocalbrain.VocalBrain;
import com.nuance.nina.listener.MyInterpretationListener;
import com.nuance.nina.mmf.MMFController;
import com.nuance.nina.observer.MyObserver;

public class ColorTrapMainActivity extends AppCompatActivity{
    private TextView mTextView;
    private String[] colorStrings = {"BLACK", "BLUE", "GRAY", "GREEN", "RED", "WHITE", "YELLOW"};
    private int[] colorIndex = {Color.BLACK, Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.WHITE, Color.YELLOW};
    private int index;
    private int lives;
    private int score;
    private int combo;
    private int timeOut = 1000*3;
    private int time;
    private MyInterpretationListener listener;
    private MyObserver observer;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colortrap_main);
        VocalBrain.setFermeTaYeule(true);
        mTextView = (TextView) findViewById(R.id.colortrap_text);
        listener = new MyInterpretationListener(this);
        observer = new MyObserver(this);
        observer.registerListeners();
        lives = 3;
        score = 0;
        time = 0;
        combo = 1;
        setNewWord();
    }
    public void setNewWord(){
        mTextView.setText(colorStrings[(int)(Math.random()*colorStrings.length)]);
        index = (int) (Math.random() * colorIndex.length);
        mTextView.setTextColor(colorIndex[index]);
        MMFController.getInstance().startListeningForRecognition();
    }
    private void analyzeInput(String input){
        if(input.equalsIgnoreCase(colorStrings[index])){
            addPoints();
            setNewWord();
            time = 0;
        }else{
            loseLife();
        }
    }
    private void loseLife(){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.fail);
        mp.start();
        lives--;
        TextView txt = (TextView) findViewById(R.id.lives);
        txt.setText("" +lives);
        combo = 1;
        if(lives == 0){
            while (mp.isPlaying()){

            }
            endGame();
        }else{
            setNewWord();
        }
    }
    private void addPoints(){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.success);
        mp.start();
        score += (10*combo);
        combo++;
        TextView txt = (TextView) findViewById(R.id.score);
        txt.setText("" + score);
    }
    private void endGame(){
        Intent activity = new Intent(this, ColorTrapScoreActivity.class);
        activity.putExtra("score", score);
        activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(activity);
    }

    public void receiveInput(String input){
        analyzeInput(input);
    }
}

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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.canyourunit.vocalbrain.R;
import com.canyourunit.vocalbrain.VocalBrain;

public class ColorTrapMainActivity extends AppCompatActivity{
    private TextView mTextView;
    private ProgressBar mProgressBar;
    private String[] colorStrings = {"BLACK", "BLUE", "GRAY", "GREEN", "RED", "WHITE", "YELLOW"};
    private int[] colorIndex = {Color.BLACK, Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.WHITE, Color.YELLOW};
    private int lives;
    private int score;
    private int combo;
    private int timeOut = 1000*3;
    private int time;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colortrap_main);
        VocalBrain.setFermeTaYeule(true);
        mTextView = (TextView) findViewById(R.id.colortrap_text);
<<<<<<< HEAD
=======
        //mProgressBar = (ProgressBar) findViewById(R.id.colortrap_progress);
>>>>>>> origin/master
        lives = 3;
        score = 0;
        time = 0;
        setNewWord();
    }
    public void setNewWord(){
        mTextView.setText(colorStrings[(int)(Math.random()*colorStrings.length)]);
        mTextView.setTextColor(colorIndex[(int)(Math.random()*colorIndex.length)]);
    }
    private void analyzeInput(String input){
        if(input.equals(mTextView.getText())){
            addPoints();
            setNewWord();
            time = 0;
        }else{
            loseLife();
        }
    }
    private void loseLife(){
        lives--;
        TextView txt = (TextView) findViewById(R.id.lives);
        txt.setText(lives);
        combo = 1;
        if(lives == 0){
            endGame();
        }
    }
    private void addPoints(){
        score += (10*combo);
        TextView txt = (TextView) findViewById(R.id.score);
        txt.setText(score);
    }
    private void endGame(){
        Intent activity = new Intent(this, ColorTrapScoreActivity.class);
        activity.putExtra("score", score);
        startActivity(activity);
    }
}

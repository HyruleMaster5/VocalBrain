/***************************************************************************************************
 * Main activity of the minigame World Scramble
 *
 * @author: Gabriel Bélanger
 * @since: 1.0.0 2016-01-23
 * *************************************************************************************************
 * Date       Author Description
 * ---------- ------ -------------------------------------------------------------------------------
 */
package com.canyourunit.vocalbrain.activities.wordscramble;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.canyourunit.vocalbrain.R;

import java.util.ArrayList;
import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WordScrambleMainActivity extends AppCompatActivity{
    private String[] dictionary = {"Apple", "Banana", "Ceiling", "Lunch", "Outstanding", "Sufficient", "Accounts", "Bounced", "Books"};
    private String[] debugdictionary = {"Apple", "Banana"};
    private String word;
    private LinearLayout ll;
    private int lives;
    private int score;
    private int combo;
    private int timeOut = 1000*3;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordscramble_main);
        lives = 3;
        score = 0;
        ll = (LinearLayout) findViewById(R.id.block_layout);
        setWord();
    }
    public String ScrambleWord(String inputString){
        //Creating a random object
        Random random = new Random();
        // Convert string into char array
        char array[] = inputString.toCharArray();
        // Scramble the letters
        for(int i=0; i < array.length-1; i++ )
        {
            int j = random.nextInt(array.length-1);
            // Swap letters
            char temp = array[i]; array[i] = array[j];  array[j] = temp;
        }
        return new String(array);
    }
    public void setWord(){
        //Creating a random object
        Random random = new Random();
        //Choose a word randomly from the dictionary
        word = dictionary[random.nextInt(dictionary.length-1)]; //Choosing random word from dictionary. Change to debugdictionary for a 2 word dictionary
        //Scrambling the word;
        word = ScrambleWord(word);
        ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.letterblock);
        image.setLayoutParams(lparams);
       for(int i = 0; i < word.length(); i++){
           TextView block = new TextView(this);
           block.setLayoutParams(lparams);
           block.setText(String.valueOf(word.charAt(i)));
           ll.addView(block);
           //ll.addView(image);
        }

    }
    private void analyzeInput(String input){
        if(input.equals(word)){
            addPoints();
            setWord();
        }
        else{
            loseLife();
        }
    }
    private void loseLife(){
        lives--;
        combo = 1;
        if(lives == 0){
            endGame();
        }
    }
    private void addPoints(){score += (10*combo);
    }
    private void endGame(){
        Intent activity = new Intent(this, WordScrambleScoreActivity.class);
        activity.putExtra("score", score);
        startActivity(activity);
    }
}

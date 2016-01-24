package com.canyourunit.vocalbrain.activities.wordscramble;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.canyourunit.vocalbrain.R;

import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;

/**
 * Created by Gabriel on 2016-01-23.
 */
public class WordScrambleMainActivity extends AppCompatActivity{

    private String[] dictionary = {"Apple", "Banana", "Ceiling", "Lunch", "Outstanding", "Sufficient", "Accounts", "Bounced", "Books"};
    private String[] debugdictionary = {"Apple", "Banana"};
    private String word;
    private  layout;
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
        setWord();
        layout = (RelativeLayout) findViewById(R.id.blocklayout);
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

        for(int i = 0; i < word.length(); i++){
            LetterBlock block = new LetterBlock(word.charAt(i));
            layout.
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

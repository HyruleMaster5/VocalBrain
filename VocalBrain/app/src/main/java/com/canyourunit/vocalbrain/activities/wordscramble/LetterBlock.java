package com.canyourunit.vocalbrain.activities.wordscramble;

import android.widget.ImageView;
import android.widget.TextView;

import com.canyourunit.vocalbrain.R;

/**
 * Created by Gabriel on 2016-01-23.
 */
public class LetterBlock {

    private TextView letter;
    //private final ImageView block = R.drawable.block.png;    //Default image

    public LetterBlock(){                                      //Default constructor
        letter.setText("A");
    }

    public LetterBlock(char inputletter){                    //Custom constructor
        letter.setText(inputletter);
    }

    public char getLetter(){
        return letter.getText().charAt(0);
    }

    public void setLetter(char inputletter){
        letter.setText(inputletter);
    }

}

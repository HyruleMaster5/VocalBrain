/***************************************************************************************************
 * Main activity of the minigame Color Trap
 *
 * @author: Christian Hardy-Cardinal
 * @since: 1.0.0 2016-01-23
 * *************************************************************************************************
 * Date       Author Description
 * ---------- ------ -------------------------------------------------------------------------------
 */
package com.canyourunit.vocalbrain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.canyourunit.vocalbrain.R;

public class ColorTrapActivity extends AppCompatActivity{
    private TextView mTextView;
    private String[] colors = {"BLACK", "BLUE", "GRAY", "GREEN", "RED", "WHITE", "YELLOW"};
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colortrap_activity);
        mTextView = (TextView) findViewById(R.id.colortrap_text);
        setNewWord();
    }

    private String generateWords(){
        Log.d(ColorTrapActivity.class.getName(), String.valueOf(colors.length));
        int randomNumber = (int)(Math.random()*colors.length);
        return colors[randomNumber];
    }

    public void setNewWord(){
        mTextView.setText(generateWords());
    }
}

/***************************************************************************************************
 * Score activity of the minigame Color Trap
 *
 * @author: Christian Hardy-Cardinal
 * @since: 1.0.0 2016-01-23
 * *************************************************************************************************
 * Date       Author Description
 * ---------- ------ -------------------------------------------------------------------------------
 */
package com.canyourunit.vocalbrain.activities.colortrap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.canyourunit.vocalbrain.R;

public class ColorTrapScoreActivity extends AppCompatActivity{
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        score = getIntent().getIntExtra("score", 0);
        setContentView(R.layout.endgame);
        TextView txt = (TextView) findViewById(R.id.score);
        txt.setText("" + score);
    }
}

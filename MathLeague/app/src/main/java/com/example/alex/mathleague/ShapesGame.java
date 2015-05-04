package com.example.alex.mathleague;

/**
 * Created by Hanna on 4/20/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ShapesGame extends Activity {

    public static int timesIncorrect = 0, hintCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_addition_game);

        TextView hint = (TextView) this.findViewById(R.id.hintbutton);

        TextView imageButton = (TextView) this.findViewById(R.id.imageButton);
        TextView imageButton2 = (TextView) this.findViewById(R.id.imageButton2);
        TextView imageButton3 = (TextView) this.findViewById(R.id.imageButton3);
        TextView imageButton4 = (TextView) this.findViewById(R.id.imageButton4);

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintCount++;
                if(hintCount % 2 != 0)
                    Toast.makeText(getApplicationContext(), "A triangle has 3 sides", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Count the number of sides", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });


        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), ShapesGame2.class);
                startActivity(it);
            }
        });
    }

    static int length = 0;

    @Override
    protected void onUserLeaveHint(){
        super.onUserLeaveHint();
        MainActivity.player.pause();
        length = MainActivity.player.getCurrentPosition();
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(!MainActivity.player.isPlaying()) {
            MainActivity.player.seekTo(length);
            MainActivity.player.start();
        }
    }
}

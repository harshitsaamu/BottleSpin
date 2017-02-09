package com.hgc.bottlespin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class roll_bottle extends AppCompatActivity {
    ImageView bottle,table;
    Random rand;
    int angle,changed_angle=0;
    int dialerHeight;
    int player,total_player=4;
    private GestureDetector gestureListener;
    int dialerWidth;
    boolean isRotating=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_bottle);

        bottle=(ImageView)findViewById(R.id.id_bottle);
        table=(ImageView)findViewById(R.id.id_table);
        rand=new Random();
//        bottle.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                if( dialerHeight==0 || dialerWidth==0){
//                    dialerHeight=bottle.getHeight();
//                    dialerWidth=bottle.getWidth();
//                }
//            }
//        });
//        if (!isRotating)
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=rand.nextInt(total_player);
                angle=player*360/total_player;
//                angle=rand.nextInt(7200)+720;
                RotateAnimation ranim=new RotateAnimation(changed_angle,angle,RotateAnimation.RELATIVE_TO_SELF,0.5f
                ,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                changed_angle=angle;
                ranim.setFillAfter(true);
                ranim.setDuration(3600);
                ranim.setInterpolator(new AccelerateDecelerateInterpolator());
                bottle.startAnimation(ranim);
                switch (player)
                {
                    case 1:
                        Toast.makeText(roll_bottle.this, "Player 1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(roll_bottle.this, "Player 2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(roll_bottle.this, "Player 3", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(roll_bottle.this, "Player 4", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
//                if (changed_angle>=0 && changed_angle<90)
//                {
//                    Toast.makeText(roll_bottle.this, "Player 1", Toast.LENGTH_SHORT).show();
//                }
//                else if(changed_angle>=90 && changed_angle<180)
//                {
//                    Toast.makeText(roll_bottle.this, "Player 2", Toast.LENGTH_SHORT).show();
//                }
//                else if(changed_angle>=180 && changed_angle<270)
//                {
//                    Toast.makeText(roll_bottle.this, "Player 3", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(roll_bottle.this, "Player 4", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}

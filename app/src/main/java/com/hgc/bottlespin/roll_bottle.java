package com.hgc.bottlespin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class roll_bottle extends AppCompatActivity {
    ImageView bottle,table;
    Random rand;
    int angle,changed_angle=0;
    int player,total_player=10;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_bottle);

        bottle=(ImageView)findViewById(R.id.id_bottle);
        table=(ImageView)findViewById(R.id.id_table);
        rand=new Random();
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=rand.nextInt(total_player*100)/100;
                angle=(player*(360/total_player))+7200;
//                angle=rand.nextInt(7200)+720;
                RotateAnimation ranim=new RotateAnimation(changed_angle,angle,RotateAnimation.RELATIVE_TO_SELF,0.5f
                ,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                changed_angle=angle%360;
                ranim.setFillAfter(true);
                ranim.setDuration(3600);
                ranim.setInterpolator(new AccelerateDecelerateInterpolator());
                bottle.startAnimation(ranim);
                ranim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        switch (player)
                        {
                            case 0:
                                Toast.makeText(roll_bottle.this, "Player 1", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(roll_bottle.this, "Player 2", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(roll_bottle.this, "Player 3", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                Toast.makeText(roll_bottle.this, "Player 4", Toast.LENGTH_SHORT).show();
                                break;
                            case 4:
                                Toast.makeText(roll_bottle.this, "Player 5", Toast.LENGTH_SHORT).show();
                                break;
                            case 5:
                                Toast.makeText(roll_bottle.this, "Player 6", Toast.LENGTH_SHORT).show();
                                break;
                            case 6:
                                Toast.makeText(roll_bottle.this, "Player 7", Toast.LENGTH_SHORT).show();
                                break;
                            case 7:
                                Toast.makeText(roll_bottle.this, "Player 8", Toast.LENGTH_SHORT).show();
                                break;
                            case 8:
                                Toast.makeText(roll_bottle.this, "Player 9", Toast.LENGTH_SHORT).show();
                                break;
                            case 9:
                                Toast.makeText(roll_bottle.this, "Player 10", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
}

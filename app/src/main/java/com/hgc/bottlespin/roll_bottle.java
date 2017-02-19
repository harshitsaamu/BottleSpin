package com.hgc.bottlespin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
    ImageView bottle, table;
    Random rand;
    int flag;
    int angle, changed_angle = 0;
    int player, total_player;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_bottle);
        Bundle bundle=getIntent().getExtras();
        total_player=bundle.getInt("no_of_players");
        bottle = (ImageView) findViewById(R.id.id_bottle);
        table = (ImageView) findViewById(R.id.id_table);
        rand = new Random();
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rand_gen();
                flag = player;
                angle = (player * (360 / total_player)) + 3600;
//                angle=rand.nextInt(7200)+720;
                RotateAnimation ranim = new RotateAnimation(changed_angle, angle, RotateAnimation.RELATIVE_TO_SELF, 0.5f
                        , RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                changed_angle = angle % 360;
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
                        switch (player) {
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
                        showfrag_dare_truth();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }

    void rand_gen() {
        int k;
        k=rand.nextInt(total_player * 100) / 100;
        if (flag ==k) {
            rand_gen();
        }
        else
        player = rand.nextInt(total_player * 100) / 100;
    }
    void showfrag_dare_truth()
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setCustomAnimations(
                R.animator.card_flip_right_in,
                R.animator.card_flip_right_out,
                R.animator.card_flip_left_in,
                R.animator.card_flip_left_out);
        select_truth_dare fragg=new select_truth_dare();
        fragmentTransaction.replace(R.id.activity_roll_bottle,fragg);
        fragmentTransaction.commit();
    }
}

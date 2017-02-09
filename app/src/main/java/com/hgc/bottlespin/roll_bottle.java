package com.hgc.bottlespin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;


public class roll_bottle extends AppCompatActivity {
    ImageView bottle,table;
    Random rand;
    int angle,changed_angle=0;
    int dialerHeight;
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
        if (!isRotating)
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle=rand.nextInt(3600)+720;
                RotateAnimation ranim=new RotateAnimation(changed_angle,angle,RotateAnimation.RELATIVE_TO_SELF,0.5f
                ,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                changed_angle=angle%360;
               ranim.setFillAfter(true);
                ranim.setDuration(7200);
                ranim.setInterpolator(new AccelerateDecelerateInterpolator());
                bottle.startAnimation(ranim);
            }
        });
    }
}

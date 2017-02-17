package com.hgc.bottlespin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ImageView adult=(ImageView) findViewById(R.id.adultButton);
        ImageView fun=(ImageView) findViewById(R.id.funButton);

        adult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adultmain = new Intent(Main_page.this, select_player.class);
                startActivity(adultmain);
            }
        });

        fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent funmain = new Intent(Main_page.this, select_player.class);
                startActivity(funmain);
            }
        });
    }
}

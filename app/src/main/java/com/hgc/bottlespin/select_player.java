package com.hgc.bottlespin;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.shawnlin.numberpicker.NumberPicker;

public class select_player extends AppCompatActivity {
  int totalplayer=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player);
        final ImageView vehicle=(ImageView)findViewById(R.id.vehicle);
        Button done=(Button)findViewById(R.id.Button3);

        final NumberPicker numberPicker = (NumberPicker) findViewById(R.id.horizontal_number_picker);

        // set divider color
        numberPicker.setDividerColor(ContextCompat.getColor(this, R.color.colorPrimary));
        numberPicker.setDividerColorResource(R.color.colorPrimary);


        // set formatter
        numberPicker.setFormatter(getString(R.string.number_picker_formatter));
        numberPicker.setFormatter(R.string.number_picker_formatter);

        // set text color
        numberPicker.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        numberPicker.setTextColorResource(R.color.colorPrimary);

        // set typeface
        numberPicker.setTypeface(Typeface.create(getString(R.string.roboto_light), Typeface.NORMAL));
        numberPicker.setTypeface(getString(R.string.roboto_light), Typeface.NORMAL);
        numberPicker.setTypeface(getString(R.string.roboto_light));
        numberPicker.setTypeface(R.string.roboto_light, Typeface.NORMAL);
        numberPicker.setTypeface(R.string.roboto_light);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {
                totalplayer=newVal;
                switch(newVal)
                {
                    case 2:
                        vehicle.setImageResource(R.drawable.cycle);
                        break;
                    case 3:
                        vehicle.setImageResource(R.drawable.scooter);
                        break;
                    case 4:
                        vehicle.setImageResource(R.drawable.auto);
                        break;
                    case 5:
                        vehicle.setImageResource(R.drawable.car);
                        break;
                    case 6:
                        vehicle.setImageResource(R.drawable.van);
                        break;
                    case 7:
                        vehicle.setImageResource(R.drawable.van);
                        break;
                    case 8:
                        vehicle.setImageResource(R.drawable.van);
                        break;
                }
            }

        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donePlayerSelect=new Intent(select_player.this,roll_bottle.class);
                donePlayerSelect.putExtra("no_of_players",totalplayer);
                startActivity(donePlayerSelect);
            }
        });
    }
}

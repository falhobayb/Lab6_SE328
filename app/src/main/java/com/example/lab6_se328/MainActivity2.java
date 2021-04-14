package com.example.lab6_se328;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        final int BIKE_PRICE = 100;
        final int CAR_PRICE = 300;
        final int JEEP_PRICE = 800;

        final TextView txt =  findViewById(R.id.textView2);
        final ImageView img = findViewById(R.id.img);

        int persons = sp.getInt("people1",0);
        int days = sp.getInt("days1",0);
        int license = sp.getInt("license1",0);

        int RentalPrice;

        if (persons <= 2) {RentalPrice = BIKE_PRICE * days;
            img.setImageResource(R.drawable.bike);
            txt.setText("Total Price for Your Trip is "+ RentalPrice);}
        else if(persons <= 4) {RentalPrice = CAR_PRICE * days;
            img.setImageResource(R.drawable.car);
            txt.setText("Total Price for Your Trip is "+ RentalPrice);}
        else if(persons > 4) {RentalPrice = JEEP_PRICE * days;
            img.setImageResource(R.drawable.jeep);
            txt.setText("Total Price for Your Trip is "+ RentalPrice);}

    }
}
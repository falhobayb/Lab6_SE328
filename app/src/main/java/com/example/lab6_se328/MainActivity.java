package com.example.lab6_se328;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button submit = (Button) findViewById(R.id.button);
        final EditText inp_days= (EditText) findViewById(R.id.editTextNumber3);
        final EditText inp_license= (EditText) findViewById(R.id.editTextNumber2);
        final EditText inp_num= (EditText) findViewById(R.id.editTextNumber);

        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int licenseVal = Integer.parseInt(inp_license.getText().toString());
                int peopleVal = Integer.parseInt(inp_num.getText().toString());
                int daysVal = Integer.parseInt(inp_days.getText().toString());

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("people1",peopleVal);
        editor.putInt("days1",daysVal);
        editor.putInt("license1",licenseVal);
        editor.commit();

        if (licenseVal > 0) {
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                } else {
                    Toast.makeText(MainActivity.this, "Your driving license will expire soon. Please renew it first then come back ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

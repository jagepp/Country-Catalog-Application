package com.example.midtronics_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       findViewById(R.id.button).setOnClickListener(this::activityToCountryList);

    }


    public void activityToCountryList (View v){//launches new activity
        Intent i = new Intent(this, CountryActivity.class);
        startActivity(i);
        Log.d("success","activity switched to country list");
    }


}
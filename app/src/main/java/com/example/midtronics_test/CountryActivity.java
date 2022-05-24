package com.example.midtronics_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class CountryActivity extends AppCompatActivity implements CountryAdapter.RVClickListener {

    RecyclerView rv_countryList;
    private ArrayList<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        nameList = new ArrayList<>();
        Resources res = getResources();

        rv_countryList = (RecyclerView) findViewById(R.id.rv_countryList);

        //using the string values in strings.xml, populating the recyclerView with clickable fields
        nameList.addAll(Arrays.asList(res.getStringArray(R.array.countryNames)));

        //setup the recyclerview
        rv_countryList.setAdapter(new CountryAdapter(getApplicationContext(),nameList, this));
        rv_countryList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int position) {
        Log.d("onClick",position + " clicked");

        Intent intent = new Intent(this,InfoActivity.class);
        intent.putExtra("data", nameList.get(position));
        startActivity(intent);

    }


}
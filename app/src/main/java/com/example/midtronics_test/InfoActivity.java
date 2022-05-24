package com.example.midtronics_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class InfoActivity extends AppCompatActivity {

    String receivedName, capital, pop, area, region, subregion;

    TextView capital_txt, pop_txt, area_txt, region_txt, subregion_txt, country_nm_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_info_layout);

        //find and set views needed for this activity
        country_nm_txt = findViewById(R.id.country_nm_txt);
        capital_txt = findViewById(R.id.capital_txt);
        pop_txt = findViewById(R.id.pop_txt);
        area_txt = findViewById(R.id.area_txt);
        region_txt = findViewById(R.id.region_txt);
        subregion_txt = findViewById(R.id.subregion_txt);

        //receive on click information from previous activity via intents
        Bundle bundle = getIntent().getExtras();
        receivedName = bundle.getString("data");
        Log.d("intent",receivedName + " received");
        country_nm_txt.setText(receivedName);

        //take country name and get information via REST countries API
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://restcountries.com/v3.1/name/" + receivedName + "?fields=capital,population,area,region,subregion";

// Request a string response from the provided URL.



        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url, null, response -> {

            try {//.replaceAll("[\\[\\](){}\"]","") removes unneeded punctuation in string
                JSONObject info = response.getJSONObject(0);
                capital = (info.getString("capital")).replaceAll("[\\[\\](){}\"]","");
                pop = (info.getString("population"));
                area = (info.getString("area"));
                region = (info.getString("region"));
                subregion = (info.getString("subregion"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Toast.makeText(InfoActivity.this,"Successful Request",Toast.LENGTH_SHORT).show();
            capital_txt.setText(capital);
            pop_txt.setText(pop);
            area_txt.setText(area);
            region_txt.setText(region);
            subregion_txt.setText(subregion);
        }, error -> Toast.makeText(InfoActivity.this,"Error Occurred",Toast.LENGTH_SHORT).show());


// Add the request to the RequestQueue.
        queue.add(request);


    }
}
package com.example.weatherstation_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BedroomChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom_chart);

        String method = getIntent().getStringExtra("method)");
        BedroomChartFragment chartFragment = new BedroomChartFragment();
        Bundle bundle = new Bundle();
        bundle.putString("method", method);
        chartFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, chartFragment).commit();
    }
}
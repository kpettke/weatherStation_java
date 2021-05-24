package com.example.weatherstation_java;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BedroomChartFragment extends Fragment {

    private BarChart mBarChart;
    private PieChart mPieChart;

    public BedroomChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bedroob_chart, container, false);

        mBarChart = view.findViewById(R.id.barChart);
        mPieChart = view.findViewById(R.id.pieChart);

        return  view;

    }

    private  void getDataChart(String method)
    {
        Call<List<ChartData>> call = ApiClient.getApiClient().create(ApiInterface.class).getChartInfo();

        call.enqueue(new Callback<List<ChartData>>() {
            @Override
            public void onResponse(Call<List<ChartData>> call, Response<List<ChartData>> response) {

                if (method.equals("bars"))
                {
                    List<BarEntry> barEntries = new ArrayList<>();
                    for (ChartData data : response.body())
                    {
                        barEntries.add(new BarEntry(data.getTemp(), Float.parseFloat(data.getData())));
                    }

                    BarDataSet barDataSet = new BarDataSet(barEntries, "temperatura");
                    barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                    BarData barData = new BarData(barDataSet);
                    barData.setBarWidth(0.9f);

                    mBarChart.setVisibility(View.VISIBLE);
                    mBarChart.animateY(5000);
                    mBarChart.setData(barData);
                    mBarChart.setFitBars(true);

                    Description description = new Description();
                    description.setText("Temperatura");
                    mBarChart.setDescription(description);
                    mBarChart.invalidate();

                }

                else if (method.equals("pie"))
                {
                    List<PieEntry> pieEntries = new ArrayList<>();

                    for (ChartData data : response.body() )
                    {
                        pieEntries.add(new PieEntry(data.getTemp(),data.getData()));
                    }

                    mPieChart.setVisibility(View.VISIBLE);
                    mPieChart.animateXY(5000, 5000);

                    PieDataSet pieDataSet = new PieDataSet(pieEntries,"Temperatura");
                    pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                    PieData pieData = new PieData(pieDataSet);

                    mPieChart.setData(pieData);

                    Description description = new Description();
                    description.setText("Temperatura");
                    mPieChart.setDescription(description);
                    mPieChart.invalidate();

                }



            }

            @Override
            public void onFailure(Call<List<ChartData>> call, Throwable t) {

            }
        });

    }

}
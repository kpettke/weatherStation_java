package com.example.weatherstation_java;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("json_wc.php")
    Call<List<ChartData>> getChartInfo();



}

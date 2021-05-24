package com.example.weatherstation_java;

import com.google.gson.annotations.SerializedName;

public class ChartData {

    @SerializedName("temp")
    private float temp;

    @SerializedName("hum")
    private float hum;

    @SerializedName("data")
    private String data;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHum() {
        return hum;
    }

    public void setHum(float hum) {
        this.hum = hum;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

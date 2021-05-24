package com.example.weatherstation_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Bedroom extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom1);
        mTextViewResult = findViewById(R.id.outTextViewBedJson);
        Button buttonJson = findViewById(R.id.btn_get);

        mQueue = Volley.newRequestQueue(this);



        buttonJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        //    outTextViewBedJson.setMovementMethod(new ScrollingMovementMethod());



        });
    }

    private void jsonParse(){
        String url="http://192.168.1.219/pogodynka/json_bed.php";
        //String url="http://www.json-generator.com/api/json/get/ceDeuFXsia?indent=2";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("sypialnia");

                    //  JSONArray jsonArray = new JSONArray();

                    for (int i =0; i< jsonArray.length(); i++ )

                    // for (int i =0; i<response.length(); i++ )
                    {
                        JSONObject salon = jsonArray.getJSONObject(i);

                        String id = salon.getString("id");
                        String temp = salon.getString("temp");
                        String hum = salon.getString("hum");
                        String data = salon.getString("data");

                        mTextViewResult.append( id + "           " + temp +" C"+ "                    " + hum + "%" +"                " + data +"\n\n");

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);

        TextView textView;
        textView = (TextView) findViewById(R.id.outTextViewBedJson);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

}
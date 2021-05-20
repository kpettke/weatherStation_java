package com.example.weatherstation_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 =  (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLivingroom();
            }
        });

        btn2 =  (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbedroom();
            }
        });

        btn3 =  (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOutside();
            }
        });

        btn4 =  (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbathroom();
            }
        });

    }

    public void  openLivingroom(){
        Intent intent = new Intent(this, livingroom.class);
        startActivity(intent);
    }
    public void  openOutside(){
        Intent intent = new Intent(this, outside.class);
        startActivity(intent);
    }
    public void  openbedroom(){
        Intent intent = new Intent(this, bedroom1.class);
        startActivity(intent);
    }

    public void  openbathroom(){
        Intent intent = new Intent(this, bedroom1.class);
        startActivity(intent);
    }
}
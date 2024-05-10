package com.example.practiceslot2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityEx2p2 extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_ex2p2);
        tv1 = findViewById(R.id.Ex2tv1);
        //reveive date
        Intent i1 = getIntent();
        //extract data package
        double a = Double.parseDouble(i1.getExtras().getString("a"));
        double b = Double.parseDouble(i1.getExtras().getString("b"));
        //sum
        double sum = a+b;
        //put data to screen
        tv1.setText(String.valueOf(sum));
    }
}
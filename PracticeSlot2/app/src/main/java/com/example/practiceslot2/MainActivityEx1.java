package com.example.practiceslot2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityEx1 extends AppCompatActivity {

    //var all control
    EditText txt1, txt2;
    Button btn1;
    TextView tv1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_ex1);
        //reference control to memory
        txt1 = findViewById(R.id.Ex1txt1);
        txt2 = findViewById(R.id.Ex1txt2);
        btn1 = findViewById(R.id.Ex1btn1);
        tv1 = findViewById(R.id.Ex1tv1);
        //Even Handling
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumfn();
            }
        });
    }
    void sumfn(){
        double a = Double.parseDouble(txt1.getText().toString());
        double b = Double.parseDouble(txt2.getText().toString());
        double sum = a+b;
        tv1.setText(String.valueOf(sum));
    }
}
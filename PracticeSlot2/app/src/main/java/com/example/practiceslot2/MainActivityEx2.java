package com.example.practiceslot2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityEx2 extends AppCompatActivity {
    //var all control
    EditText txt1, txt2;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_ex2);
        //reference control to memory
        txt1 = findViewById(R.id.Ex2txt1);
        txt2 = findViewById(R.id.Ex2txt2);
        btn1 = findViewById(R.id.Ex2btn1);
        //Even handling
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set route from A to B
                Intent i = new Intent(MainActivityEx2.this,MainActivityEx2p2.class);
                //put date to intent
                i.putExtra("a", txt1.getText().toString());
                i.putExtra("b", txt2.getText().toString());
                //Start
                startActivity(i);
            }
        });
    }
}
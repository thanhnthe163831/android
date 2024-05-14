package Slot2;

import android.content.Intent;
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

import com.example.slot1.R;

public class Slot23MainAcitivity extends AppCompatActivity {
    //declare vảiable
   TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot23_main_acitivity);
        tv1=findViewById(R.id.Slot23txtview);
        //receive date
        Intent i1=getIntent();
        //extract data package
        double a = Double.parseDouble(i1.getExtras().getString("a"));
        double b = Double.parseDouble(i1.getExtras().getString("b"));
        //sum
        double sum=a+b;
        //put data to screen
        tv1.setText(String.valueOf(sum));
    }
}
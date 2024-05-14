package Slot3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.slot1.R;

public class Demo34MainActivity extends AppCompatActivity {
    TextView tvQK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo34_main);
        tvQK = findViewById(R.id.demo34tv);
        //get data from intent
        Intent intent1=getIntent();
        //extract data
        int a = Integer.parseInt(intent1.getExtras().getString("hsa"));
        int b = Integer.parseInt(intent1.getExtras().getString("hsb"));
        int c = Integer.parseInt(intent1.getExtras().getString("hsc"));
        //delta = ?
        int delta=b*b-4*a*c;
        if(delta < 0) {
            tvQK.setText("PTVN");
        }
        else if (delta == 0){
            tvQK.setText("PT co nghiem kep x="+(-b)/(2*a));
        }else{
            float x1 = (float)((-b+Math.sqrt(delta))/(2*a));
            float x2 = (float)((-b-Math.sqrt(delta))/(2*a));
            tvQK.setText("PT co 2 nghiem la x1="+x1+",x2="+x2);
        }

    }
}
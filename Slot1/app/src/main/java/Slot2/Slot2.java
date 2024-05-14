package Slot2;

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

import com.example.slot1.R;

public class Slot2 extends AppCompatActivity {
    //var all control
    EditText txt1, txt2;
    Button btn1;
    TextView tv1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slot2);
        //reference control to memory
        txt1=findViewById(R.id.slot2text1);
        txt2=findViewById(R.id.slot2text2);
        btn1=findViewById(R.id.slot2btn1);
        tv1=findViewById(R.id.slot2textView);
        //even handing
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               sumfn();
            }
        });
    }
    void sumfn(){
        double a = Double.parseDouble(txt1.getText().toString());
        double b = Double.parseDouble(txt2.getText().toString());
        double s = a+b;
        tv1.setText(String.valueOf(s));
    }
}

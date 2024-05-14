package Slot3;

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

public class Demo33MainActivity extends AppCompatActivity {

    EditText txtA, txtB, txtC;
    Button btn1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo33_main);
        txtA=findViewById(R.id.demo33Hsa);
        txtB=findViewById(R.id.demo33Hsb);
        txtC=findViewById(R.id.demo33Hsc);
        btn1=findViewById(R.id.demo33btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    private void sendData(){
        //get data from input of user
        String a=txtA.getText().toString();
        String b=txtB.getText().toString();
        String c=txtC.getText().toString();
        //create intent
        Intent intent = new Intent(Demo33MainActivity.this, Demo34MainActivity.class);
        //put data to intent
        intent.putExtra("hsa", a);
        intent.putExtra("hsb", b);
        intent.putExtra("hsc", c);
        //Start Activity
        startActivity(intent);
    }
}
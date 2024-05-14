package Slot2;

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

import com.example.slot1.R;

public class Slot2A2Activity extends AppCompatActivity {

    EditText txt1, txt2;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot2_a2);
        //refer id from memory
        txt1=findViewById(R.id.slot2A2txt1);
        txt2=findViewById(R.id.slot2A2txt2);
        btn1=findViewById(R.id.Slot2A2btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set route from A to B
                Intent i = new Intent(Slot2A2Activity.this, Slot23MainAcitivity.class);
                //put date to intent
                i.putExtra("a", txt1.getText().toString());
                i.putExtra("b", txt2.getText().toString());
                //start
                startActivity(i);
            }
        });
    }
}
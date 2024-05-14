package Slot3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.slot1.R;

public class Demo31MainActivity extends AppCompatActivity {

    EditText txt1, txt2;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo31_main);
        //refer widget to id in XML layout
        txt1=findViewById(R.id.Slot3txt1);
        txt2=findViewById(R.id.Slot3txt2);
        btn1=findViewById(R.id.Slot3btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){
        if(txt1.getText().toString().equals("admin")&&txt2.getText().toString().equals("123")){
            Toast.makeText(Demo31MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Demo31MainActivity.this, "User or Pass wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
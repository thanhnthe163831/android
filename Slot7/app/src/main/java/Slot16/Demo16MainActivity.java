package Slot16;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.slot7.R;

public class Demo16MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText txtSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo16_main);
        btnSend=findViewById(R.id.demo161Btn1);
        txtSend=findViewById(R.id.demo161Txt1);
        btnSend.setOnClickListener(v->{
            //anh xa fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            Demo16BlankFragment f1 = (Demo16BlankFragment)  fragmentManager
                    .findFragmentById(R.id.demo161Fr1);
            //setText cho Edittext cua fragment
            f1.editText.setText(txtSend.getText().toString());
        });
    }
}
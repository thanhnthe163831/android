package Slot14;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.slot7.R;

public class Demo14MainActivity extends AppCompatActivity {

    Button btnSelect, btnInsert, btnUpdate, btnDelete;
    TextView tvResult;
    FnVolley fn;
    EditText txtName, txtPrice, txtDes, txtPid;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo14_main);
        btnSelect=findViewById(R.id.demo141BtnGet);
        btnInsert=findViewById(R.id.demo141BtnInsert);
        btnUpdate=findViewById(R.id.demo141BtnUpdate);
        btnDelete=findViewById(R.id.demo141BtnDelete);
        tvResult=findViewById(R.id.demo141TvResult);
        txtName=findViewById(R.id.demo141TxtName);
        txtPrice=findViewById(R.id.demo141TxtPrice);
        txtDes=findViewById(R.id.demo141TxtDes);
        txtPid=findViewById(R.id.demo141TxtPid);
        fn=new FnVolley();
        btnSelect.setOnClickListener(v->{
            fn.getArrayOfObjects(context, tvResult);
        });
        btnInsert.setOnClickListener(v->{
            fn.insertVolley(context,tvResult,txtName,txtPrice,txtDes);
        });
        btnUpdate.setOnClickListener(v->{
            fn.updateVolley(context,tvResult,txtPid,txtName,txtPrice,txtDes);
        });
        btnDelete.setOnClickListener(v->{
            fn.deleteVolley(context,tvResult,txtPid);
        });
    }
}
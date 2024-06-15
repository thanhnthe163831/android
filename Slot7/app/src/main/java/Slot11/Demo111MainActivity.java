package Slot11;

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

import com.example.slot7.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo111MainActivity extends AppCompatActivity {

    EditText txt1, txt2, txt3;
    TextView tv1;
    Button btnInsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo111_main);
        txt1 = findViewById(R.id.demo111Txt1);
        txt2 = findViewById(R.id.demo111Txt2);
        txt3 = findViewById(R.id.demo111Txt3);
        tv1=findViewById(R.id.demo111TvResult);
        btnInsert=findViewById(R.id.demo111BtnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }
    private void insertData(){
        //1.Create a object for archive data
        Prd prd = new Prd();
        //2.set data to object
        prd.setName(txt1.getText().toString());
        prd.setPrice(txt2.getText().toString());
        prd.setDescription(txt3.getText().toString());
        //3. create a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.10/202406/create_product.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //4. Call insert
        //4.0. Create a object
        InterfaceInsertPrd insertPrdObj=retrofit.create(InterfaceInsertPrd.class);
        //4.1. prepare fuction
        Call<SvrResponsePrd> call =insertPrdObj.insertPrd(prd.getName(),prd.getPrice(),prd.getDescription());
        //4.2. execute function
        call.enqueue(new Callback<SvrResponsePrd>() {
            @Override
            public void onResponse(Call<SvrResponsePrd> call, Response<SvrResponsePrd> response) {
                SvrResponsePrd svrResponsePrd=response.body();
                tv1.setText(svrResponsePrd.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponsePrd> call, Throwable throwable) {
                tv1.setText(throwable.getMessage());
            }
        });
    }
}
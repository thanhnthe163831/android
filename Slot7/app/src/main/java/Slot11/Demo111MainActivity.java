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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo111MainActivity extends AppCompatActivity {

    EditText txt1, txt2, txt3, txt0;
    TextView tv1;
    Button btnInsert, btnUpdate, btnDelete, btnSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo111_main);
        txt0 = findViewById(R.id.demo111Txt0);
        txt1 = findViewById(R.id.demo111Txt1);
        txt2 = findViewById(R.id.demo111Txt2);
        txt3 = findViewById(R.id.demo111Txt3);
        tv1=findViewById(R.id.demo111TvResult);
        btnInsert=findViewById(R.id.demo111BtnInsert);
        btnDelete=findViewById(R.id.demo121BtnDelete);
        btnUpdate=findViewById(R.id.demo121BtnUpdate);
        btnSelect=findViewById(R.id.demo121BtnSelect);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectData();
            }
        });
    }
    private List<PrdSelect> ls;
    String strResult="";
    private void selectData(){
        //2. create a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.10/202406/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //3. Call
        InterfaceSelect interfaceSelect=retrofit.create(InterfaceSelect.class);
        Call<SvrResponseSelect> call=interfaceSelect.getPrd();
        //4. execute
        call.enqueue(new Callback<SvrResponseSelect>() {
            @Override
            public void onResponse(Call<SvrResponseSelect> call, Response<SvrResponseSelect> response) {
                SvrResponseSelect svrResponseSelect = response.body();
                //convert response to list
                ls=new ArrayList<>(Arrays.asList(svrResponseSelect.getProducts()));
                //for
                for(PrdSelect p:ls){
                    strResult += "Name: "+p.getName()+"; Price: "+p.getPrice()+"; Des: "+p.getDescription()+"\n";
                }
                tv1.setText(strResult);
            }

            @Override
            public void onFailure(Call<SvrResponseSelect> call, Throwable throwable) {
                tv1.setText(throwable.getMessage());
            }
        });
    }
    private void updateData(){
        //1. Create a object for archive data
        PrdUpdate p=new PrdUpdate();
        p.setPid(txt0.getText().toString());
        p.setName(txt1.getText().toString());
        p.setPrice(txt2.getText().toString());
        p.setDescription(txt3.getText().toString());
        //2. create a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.10/202406/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //3. Call
        InterfaceUpd interfaceUdp=retrofit.create(InterfaceUpd.class);
        Call<SvrResponseUpd> call=interfaceUdp.updateExe(p.getPid(), p.getName(), p.getPrice(), p.getDescription());
        //4. execute
        call.enqueue(new Callback<SvrResponseUpd>() {
            @Override
            public void onResponse(Call<SvrResponseUpd> call, Response<SvrResponseUpd> response) {
                SvrResponseUpd svrResponseUpd = response.body();
                tv1.setText(svrResponseUpd.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponseUpd> call, Throwable throwable) {
                tv1.setText(throwable.getMessage());
            }
        });
    }
    private void deleteData(){
        //1. Create a object for archive data
        PrdDelete p=new PrdDelete();
        p.setPid(txt0.getText().toString());
        //2. create a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.10/202406/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //3. Call
        InterfaceDel interfaceDel=retrofit.create(InterfaceDel.class);
        Call<SvrResponseDel> call=interfaceDel.deleteExe(p.getPid());
        //4. execute
        call.enqueue(new Callback<SvrResponseDel>() {
            @Override
            public void onResponse(Call<SvrResponseDel> call, Response<SvrResponseDel> response) {
                SvrResponseDel svrResponseDel = response.body();
                tv1.setText(svrResponseDel.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponseDel> call, Throwable throwable) {
                tv1.setText(throwable.getMessage());
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
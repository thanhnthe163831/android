package Slot3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.slot1.R;

public class Demo32MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo32_main);
        //reference
        listView=findViewById(R.id.demo32lv);
        //create data source
        getDataToListView();
    }
    private void getDataToListView(){
        //1. create data source
        String[] arr = new String[]{
                "Lap trinh java 1",
                "Computer science introduction",
                "Mobile programing",
                "Cross-flatform with .Net",
                "Javascript Introduction"
        };
        //2.using adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Demo32MainActivity.this,
                android.R.layout.simple_list_item_1, arr);
        //3. acttach adapter to listview
        listView.setAdapter(adapter);
    }
}
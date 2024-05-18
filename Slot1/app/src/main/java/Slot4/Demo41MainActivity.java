package Slot4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.slot1.R;

import java.util.ArrayList;
import java.util.List;

public class Demo41MainActivity extends AppCompatActivity {
    private ListView listView;
    private Demo41BaseAdapter adapter;
    private List<Demo41Student> list = new ArrayList<>();
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo41_main);
        listView=findViewById(R.id.demo41listview);
        list.add(new Demo41Student("Nguyen Van A", "18",R.drawable.android));
        list.add(new Demo41Student("Nguyen Van B", "18",R.drawable.apple));
        list.add(new Demo41Student("Nguyen Van C", "18",R.drawable.blogger));
        list.add(new Demo41Student("Nguyen Van D", "18",R.drawable.hp));
        list.add(new Demo41Student("Nguyen Van E", "18",R.drawable.chrome));
        list.add(new Demo41Student("Nguyen Van F", "18",R.drawable.dell));

        adapter = new Demo41BaseAdapter(this, list);
        listView.setAdapter(adapter);
    }
}
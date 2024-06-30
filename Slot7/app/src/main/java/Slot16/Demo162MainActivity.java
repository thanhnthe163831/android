package Slot16;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.slot7.R;
import com.google.android.material.tabs.TabLayout;

public class Demo162MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo162_main);
        viewPager=findViewById(R.id.demo162_viewPager);
        tabLayout=findViewById(R.id.demo162_tablayout);
        addTabLayout(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
    public void addTabLayout(ViewPager viewPager){
        //tao Adapter
        Demo163Adapter adapter = new Demo163Adapter(getSupportFragmentManager());
        //them fragment
        adapter.addFragment(new Demo16BlankFragment(), "ONE");
        adapter.addFragment(new Demo16BlankFragment2(), "TWO");
        adapter.addFragment(new Demo16BlankFragment3(), "THREE");
        //dua adapter ket noi voi viewPager
        viewPager.setAdapter(adapter);
    }
}
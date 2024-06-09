package Slot9;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.slot7.R;

import java.util.List;

public class Demo10CartActivity extends AppCompatActivity {

    private ListView listView;
    private Demo10CartAdapter adapter;
    Demo10CartManager cartManager;//gio hang
    List<Product91> cartItems;//san pham trong gio hang
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo10_cart);
        listView=findViewById(R.id.demo10_CartActivity_Listview);
        //----
        cartManager=Demo10CartManager.getInstance();
        cartItems=cartManager.getCartItems();
        //----
        adapter=new Demo10CartAdapter(this, cartItems);
        listView.setAdapter(adapter);
    }
}
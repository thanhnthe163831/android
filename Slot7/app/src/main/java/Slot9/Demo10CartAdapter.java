package Slot9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.slot7.R;

import java.util.List;

public class Demo10CartAdapter extends ArrayAdapter<Product91> {

    private Context mContext;
    public Demo10CartAdapter(Context context, List<Product91> products) {
        super(context, 0, products);
        mContext=context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem=convertView;
        if(listItem==null){
            listItem= LayoutInflater.from(mContext).inflate(R.layout.demo10_cart_item, parent, false);
        }
        //get current product
        Product91 currentProduct=getItem(position);
        //display product info
        TextView productName=listItem.findViewById(R.id.demo10_cartItem_tvProductName);
        productName.setText(currentProduct.getStyleId());
        //display quantity of product
        TextView productQuantity=listItem.findViewById(R.id.demo10_cartItem_tvProductQuantity);
        productQuantity.setText("Quantity: "+1);
        return listItem;
    }
}

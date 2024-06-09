package Slot9;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slot7.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class demo91Adapter extends BaseAdapter {
    private Context mContext;
    private List<Product91> mList;

    public demo91Adapter(Context mContext, List<Product91> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder91 holder;
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.demo91_itemview,parent,false);
            holder=new ViewHolder91();
            holder.imageView=convertView.findViewById(R.id.demo91_itemview_searchImage);
            holder.styleIDTv=convertView.findViewById(R.id.demo91_itemview_TvStyleid);
            holder.brandTv=convertView.findViewById(R.id.demo91_itemview_TvBrand);
            holder.priceTv=convertView.findViewById(R.id.demo91_itemview_TvPrice);
            holder.infoTv=convertView.findViewById(R.id.demo91_itemview_TvInfo);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder91) convertView.getTag();
        }
        //set data
        Product91 product=mList.get(position);
        if(product!=null){
            Picasso.get().load(product.getSearchImage()).into(holder.imageView);
            holder.styleIDTv.setText(product.getStyleId());
            holder.brandTv.setText(product.getBrand());
            holder.priceTv.setText(product.getPrice());
            holder.infoTv.setText(product.getInfo());
        }
        //----event---
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product91 product = mList.get(position);
                Intent intent = new Intent(mContext, Demo10MainActivity.class);
                intent.putExtra("PRODUCT", product);
                mContext.startActivity(intent);
            }
        });
        //------------
        return convertView;
    }

    static class ViewHolder91{
        ImageView imageView;
        TextView styleIDTv, brandTv, priceTv, infoTv;
    }
}

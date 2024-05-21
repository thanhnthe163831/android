package Slot5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Demo51ProductDAO {
    private  Demo51SqliteHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;
    //create db and table
    public Demo51ProductDAO(Context context){
        this.context=context;
        dbHelper=new Demo51SqliteHelper(context);
        db=dbHelper.getWritableDatabase();
    }
    //insert
    public int insertProduct(Demo51Product p){
        ContentValues values=new ContentValues();//data for insert
        //put data
        values.put("id",p.getId());
        values.put("name",p.getName());
        values.put("price",p.getPrice());
        //insert
        if(db.insert("Product",null,values)<0){
            return -1;//unsuccessful
        }
        return 1;//successful
    }
    //get data
    public List<Demo51Product> getAll(){
        List<Demo51Product> list=new ArrayList<>();
        //cursor read data
        Cursor c=db.query("Product",null,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            Demo51Product product=new Demo51Product();
            product.setId(c.getString(0));
            product.setName(c.getString(1));
            product.setPrice(c.getDouble(2));
            list.add(product);
            c.moveToNext();
        }
        c.close();
        return list;
    }
}

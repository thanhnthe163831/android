package Slot6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Demo61SQLiteHelper extends SQLiteOpenHelper {
    public static final String SQL_CREATE_TABLE_SANPHAM="Create TABLE sanpham(\n" +
            "masp text PRIMARY KEY,\n" +
            "tensp text,\n" +
            "soLuongSP text\n" +
            ");";

    public Demo61SQLiteHelper(Context context) {
        super(context, "QLSP", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_SANPHAM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sanpham;");
    }
}

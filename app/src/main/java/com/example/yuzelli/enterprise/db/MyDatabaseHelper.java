package com.example.yuzelli.enterprise.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by 51644 on 2017/5/10.
 */

public class MyDatabaseHelper  extends SQLiteOpenHelper {
    public static final String CREATE_BOOK = "create table enterprise ("
            + "id integer primary key autoincrement,"
            + "time text,"
            + "securityone text,"
            + "securitytwo text,"
            + "securitythree text,"
            + "securityfour text,"
            + "securityfive text,"
            + "securitysix text,"
            + "securityseven text,"
            + "securityeight text,"
            + "securitynine text)";
    private Context mcontext;



    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext =context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);//创建数据库
        Toast.makeText(mcontext,"create enterprise",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

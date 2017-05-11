package com.example.yuzelli.enterprise.db;

/**
 * Created by 51644 on 2017/5/10.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.yuzelli.enterprise.bean.Project;

import java.util.ArrayList;
public class DatabaseAdapter {
    private MyDatabaseHelper dbHelper;
    //数据库名字
    private static final String DB_NAME = "enterprise.db";
    public DatabaseAdapter(Context context) {
        dbHelper = new MyDatabaseHelper(context,DB_NAME,null,1);
    }
    /**
     * 添加数据
     */
    public void create(Project proj) {
        String sql = "insert into enterprise(time, securityone, securitytwo, securitythree,securityfour,securityfive,securitysix,securityseven,securityeight,securitynine)values(?,?,?,?,?,?,?,?,?,?)";
        Object[] args = {proj.getTime(),proj.getSecurityone(),proj.getSecuritytwo(),proj.getSecuritythree(),proj.getSecurityfour(),proj.getSecurityfive(),proj.getSecuritysix(),proj.getSecurityseven(),proj.getSecurityeight(),proj.getSecuritynine()};
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(sql, args);
        db.close();
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public void remove(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from enterprise where id = ?";
        Object[] args = {id};
        db.execSQL(sql, args);
        db.close();
    }

    /**
     * 修改数据
     *
     */
    public void update(Project proj) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "update enterprise set time = ?, securityone = ?, securitytwo = ?, securitythree = ?,securityfour = ?,securityfive = ?,securitysix = ?,securityseven = ?, securityeight =  ? ,securitynine=?  where id = ?";
        Object[] args = {proj.getTime(),proj.getSecurityone(),proj.getSecuritytwo(),proj.getSecuritythree(),proj.getSecurityfour(),proj.getSecurityfive(),proj.getSecuritysix(),proj.getSecurityseven(),proj.getSecurityeight(),proj.getSecuritynine(),proj.getId()};
        db.execSQL(sql, args);
        db.close();
    }

    /**
     * 按id查询
     *
     * @param id
     * @return
     */
    public Project findById(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from enterprise where id = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(id)});

        Project proj = null;
        if (cursor.moveToNext()) {
            proj = new Project();
            proj.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            proj.setTime(cursor.getString(cursor.getColumnIndexOrThrow("time")));
            proj.setSecurityone(cursor.getString(cursor.getColumnIndexOrThrow("securityone")));
            proj.setSecuritytwo(cursor.getString(cursor.getColumnIndexOrThrow("securitytwo")));
            proj.setSecuritythree(cursor.getString(cursor.getColumnIndexOrThrow("securitythree")));
            proj.setSecurityfour(cursor.getString(cursor.getColumnIndexOrThrow("securityfour")));
            proj.setSecurityfive(cursor.getString(cursor.getColumnIndexOrThrow("securityfive")));
            proj.setSecuritysix(cursor.getString(cursor.getColumnIndexOrThrow("securitysix")));
            proj.setSecurityseven(cursor.getString(cursor.getColumnIndexOrThrow("securityseven")));
            proj.setSecurityeight(cursor.getString(cursor.getColumnIndexOrThrow("securityeight")));
            proj.setSecuritynine(cursor.getString(cursor.getColumnIndexOrThrow("securitynine")));
        }
        cursor.close();
        db.close();

        return proj;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public ArrayList<Project> findAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from enterprise";
        Cursor cursor = db.rawQuery(sql,null);


        ArrayList<Project> notes = new ArrayList<>();
        Project proj = null;
        while (cursor.moveToNext()) {
            proj = new Project();
            proj.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            proj.setTime(cursor.getString(cursor.getColumnIndexOrThrow("time")));
            proj.setSecurityone(cursor.getString(cursor.getColumnIndexOrThrow("securityone")));
            proj.setSecuritytwo(cursor.getString(cursor.getColumnIndexOrThrow("securitytwo")));
            proj.setSecuritythree(cursor.getString(cursor.getColumnIndexOrThrow("securitythree")));
            proj.setSecurityfour(cursor.getString(cursor.getColumnIndexOrThrow("securityfour")));
            proj.setSecurityfive(cursor.getString(cursor.getColumnIndexOrThrow("securityfive")));
            proj.setSecuritysix(cursor.getString(cursor.getColumnIndexOrThrow("securitysix")));
            proj.setSecurityseven(cursor.getString(cursor.getColumnIndexOrThrow("securityseven")));
            proj.setSecurityeight(cursor.getString(cursor.getColumnIndexOrThrow("securityeight")));
            proj.setSecuritynine(cursor.getString(cursor.getColumnIndexOrThrow("securitynine")));
            notes.add(proj);
        }
        cursor.close();
        db.close();
        return notes;
    }



}

package com.example.razzon.smarthealthpredictor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

/**
 * Created by RAZZON on 4/13/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "SmartHealthPredictor";
    static int version = 1;

    public DatabaseHelper(Context context) {
        super(context, name, null, version);

        String SqlCreateRegistrationTable = "CREATE TABLE if not exists `RegistrationForm` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `FullName` TEXT, `UserName` TEXT, `Address` TEXT, `PhoneNo` TEXT, `Age` TEXT, `Email` TEXT, `Password` TEXT, `Gender` TEXT )";

        getWritableDatabase().execSQL(SqlCreateRegistrationTable);
    }

    //Insert Into db from registration form
    public void InsertUser(ContentValues cv) {
        getWritableDatabase().insert("RegistrationForm", "", cv);
    }

    public void UpdateUser(ContentValues cv,String id){
    getWritableDatabase().update("RegistrationForm",cv,"id="+id,null);
    }

    public void DeleteUser(String id) {
        getWritableDatabase().delete("RegistrationForm", "id=" + id, null);
    }

    public boolean IsLoginSuccessfull(String username, String password) {
        String sql = "SELECT COUNT(*) FROM RegistrationForm WHERE UserName='" + username + "' and Password='" + password + "'";

        SQLiteStatement statement = getWritableDatabase().compileStatement(sql);

        long l = statement.simpleQueryForLong();
        statement.close();
        if (l > 0) {
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<UserDetails> GetUserList() {

        String Sql = "SELECT * FROM RegistrationForm";
        //Adding user info into arraylist
        Cursor c = getWritableDatabase().rawQuery(Sql, null);
        ArrayList<UserDetails> list = new ArrayList<UserDetails>();

        while (c.moveToNext()) {
            UserDetails info = new UserDetails();
            info.id = c.getString(c.getColumnIndex("id"));
            info.fullname = c.getString(c.getColumnIndex("FullName"));
            info.username = c.getString(c.getColumnIndex("UserName"));
            info.password = c.getString(c.getColumnIndex("Password"));
            info.address = c.getString(c.getColumnIndex("Address"));
            info.phonenum = c.getString(c.getColumnIndex("PhoneNo"));
            info.age = c.getString(c.getColumnIndex("Age"));
            info.email = c.getString(c.getColumnIndex("Email"));
            info.gender = c.getString(c.getColumnIndex("Gender"));

            list.add(info);

        }
        c.close();
        return list;

    }

    public UserDetails GetUserInfo(String id) {

        String Sql = "SELECT * FROM RegistrationForm where id="+id;

        Cursor c = getWritableDatabase().rawQuery(Sql, null);
        UserDetails info = new UserDetails();

        while (c.moveToNext()) {
            info.id = c.getString(c.getColumnIndex("id"));
            info.fullname = c.getString(c.getColumnIndex("FullName"));
            info.username = c.getString(c.getColumnIndex("UserName"));
            info.password = c.getString(c.getColumnIndex("Password"));
            info.address = c.getString(c.getColumnIndex("Address"));
            info.phonenum = c.getString(c.getColumnIndex("PhoneNo"));
            info.age = c.getString(c.getColumnIndex("Age"));
            info.email = c.getString(c.getColumnIndex("Email"));
            info.gender = c.getString(c.getColumnIndex("Gender"));


        }
        c.close();
        return info;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.razzon.login_form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

/**
 * Created by RAZZON on 3/26/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "SmartHealthPredictor";
    static int version = 1;

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        String SqlCreateRegistrationTable = "CREATE TABLE if not exists `RegistrationForm` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `FirstName` TEXT, `LastName` TEXT, `Address` TEXT, `PhoneNo` TEXT, `Age` TEXT, `Email` TEXT, `Password` TEXT,`BloodGroup` TEXT, `Gender` TEXT ,'Image' BLOB)";
        // String SqlCreateDoctorsTable = "CREATE TABLE if not exists \"Doctor\" ( `id` INTEGER, `Name` TEXT, `Address` TEXT, `PhoneNo.` TEXT, `Expertise` TEXT, `Hospital` TEXT, PRIMARY KEY(`id`) )";
        //String SqlCreateSymptomsTable = "CREATE TABLE if not exists`Symptoms` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `Symptoms` TEXT )";
        //String SqlCreateDiseasesTable = "CREATE TABLE if not exists`Diseases` ( `Did` INTEGER PRIMARY KEY AUTOINCREMENT, `Name` TEXT, `Type` TEXT )";
        //String SqlCreateRemainderTable = "CREATE TABLE if not exists`Remainder` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `Medicine` TEXT, `Time` TEXT )";
        // String sqlCreateFeedbackTable="CREATE TABLE if not exists`FeedBack` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `Description` TEXT, `Time` TEXT )"
        getWritableDatabase().execSQL(SqlCreateRegistrationTable);
        // getWritableDatabase().execSQL(SqlCreateDoctorsTable);
        // getWritableDatabase().execSQL(SqlCreateSymptomsTable);
        //getWritableDatabase().execSQL(SqlCreateDiseasesTable);
        //getWritableDatabase().execSQL(SqlCreateRemainderTable);

    }

    public void InsertUser(ContentValues cv) {
        getWritableDatabase().insert("RegistrationForm", "", cv);
        getWritableDatabase().insert("Feedback", "", cv);

    }

    public void UpdateUser(ContentValues cv, String id) {
        getWritableDatabase().update("RegistrationForm", cv, "id=" + id, null);
        //getWritableDatabase().update("RegistrationForm",cv,"id=?",new String[]{id});
    }

    public void DeleteUser(String id) {
        getWritableDatabase().delete("RegistrationForm", "id=" + id, null);
    }


    public UserDetails getUserLoggedIn(String email, String password) {
        String sql = "SELECT * FROM RegistrationForm WHERE Email='" + email + "' and Password='" + password + "'";
        Cursor c = getWritableDatabase().rawQuery(sql, null);

        UserDetails Details = new UserDetails();
        while (c.moveToNext()) {
            Details.id = c.getString(c.getColumnIndex("id"));
            Details.firstname = c.getString(c.getColumnIndex("FirstName"));
            Details.lastname = c.getString(c.getColumnIndex("LastName"));
            Details.password = c.getString(c.getColumnIndex("Password"));
            Details.address = c.getString(c.getColumnIndex("Address"));
            Details.phonenumber = c.getString(c.getColumnIndex("PhoneNo"));
            Details.age = c.getString(c.getColumnIndex("Age"));
            Details.bloodgroup = c.getString(c.getColumnIndex("BloodGroup"));
            Details.email = c.getString(c.getColumnIndex("Email"));
            Details.gender = c.getString(c.getColumnIndex("Gender"));
            Details.image=c.getBlob(c.getColumnIndex("Image"));


        }
        c.close();
        return Details;

    }


    public boolean IsLoginSuccessfull(String email, String password) {
        String sql = "SELECT COUNT(*) FROM RegistrationForm WHERE Email='" + email + "' and Password='" + password + "'";

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
        Cursor c = getWritableDatabase().rawQuery(Sql, null);
        ArrayList<UserDetails> list = new ArrayList<UserDetails>();

        while (c.moveToNext()) {
            UserDetails Details = new UserDetails();
            Details.id = c.getString(c.getColumnIndex("id"));
            Details.firstname = c.getString(c.getColumnIndex("FirstName"));
            Details.lastname = c.getString(c.getColumnIndex("LastName"));
            Details.password = c.getString(c.getColumnIndex("Password"));
            Details.address = c.getString(c.getColumnIndex("Address"));
            Details.phonenumber = c.getString(c.getColumnIndex("PhoneNo"));
            Details.age = c.getString(c.getColumnIndex("Age"));
            Details.bloodgroup = c.getString(c.getColumnIndex("BloodGroup"));
            Details.email = c.getString(c.getColumnIndex("Email"));
            Details.gender = c.getString(c.getColumnIndex("Gender"));
            Details.image=c.getBlob(c.getColumnIndex("Image"));

            list.add(Details);

        }
        c.close();
        return list;
    }

    public UserDetails GetUserInfo(String id) {
        String Sql = "SELECT * FROM RegistrationForm where id='" + id + "'";
        Cursor c = getWritableDatabase().rawQuery(Sql, null);

        UserDetails Details = new UserDetails();
        while (c.moveToNext()) {
            Details.id = c.getString(c.getColumnIndex("id"));
            Details.firstname = c.getString(c.getColumnIndex("FirstName"));
            Details.lastname = c.getString(c.getColumnIndex("LastName"));
            Details.password = c.getString(c.getColumnIndex("Password"));
            Details.address = c.getString(c.getColumnIndex("Address"));
            Details.phonenumber = c.getString(c.getColumnIndex("PhoneNo"));
            Details.age = c.getString(c.getColumnIndex("Age"));
            Details.bloodgroup = c.getString(c.getColumnIndex("BloodGroup"));
            Details.email = c.getString(c.getColumnIndex("Email"));
            Details.gender = c.getString(c.getColumnIndex("Gender"));
            //Details.image=c.getBlob(c.getColumnIndex("Image"));


        }
        c.close();
        return Details;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
























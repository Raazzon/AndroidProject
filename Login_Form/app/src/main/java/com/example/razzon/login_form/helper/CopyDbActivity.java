package com.example.razzon.login_form.helper;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.razzon.login_form.R;

import java.io.IOException;

public class CopyDbActivity extends AppCompatActivity {

    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ((Button) findViewById(R.id.login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dh myDbHelper = new dh(CopyDbActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                try {
                    myDbHelper.openDataBase();
                } catch (SQLException sqle) {
                    throw sqle;
                }
                Toast.makeText(CopyDbActivity.this, "Successfully Imported", Toast.LENGTH_SHORT).show();
                c = myDbHelper.query("PLEASE CHANGE TO YOUR TABLE NAME", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(CopyDbActivity.this,
                                "_id: " + c.getString(0) + "\n" +
                                        "DATE: " + c.getString(1) + "\n" +
                                        "TIME: " + c.getString(2) + "\n" +
                                        "HEIGHT:  " + c.getString(3),
                                Toast.LENGTH_LONG).show();
                    } while (c.moveToNext());
                }
            }
        });

    }


}

package com.example.razzon.login_form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class search_doctor extends AppCompatActivity {
Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_doctor);
        spinner= (Spinner) findViewById(R.id.spinerd);
    }
}

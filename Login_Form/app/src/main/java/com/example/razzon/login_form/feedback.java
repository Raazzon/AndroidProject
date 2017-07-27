package com.example.razzon.login_form;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class feedback extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Button submit;
    EditText feedback;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        databaseHelper=new DatabaseHelper(this);
        submit= (Button) findViewById(R.id.submit);
        feedback= (EditText) findViewById(R.id.ef);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String feedbackValue = feedback.getText().toString();

                ContentValues cv = new ContentValues();


                    databaseHelper.InsertUser(cv);
                    Toast.makeText(feedback.this, "Feedback Provided", Toast.LENGTH_LONG).show();


            }
        });
    }

}

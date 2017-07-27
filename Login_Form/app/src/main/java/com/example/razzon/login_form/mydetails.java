package com.example.razzon.login_form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class mydetails extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    LinearLayout Container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydetails);
        databaseHelper=new DatabaseHelper(this);
        Container= (LinearLayout) findViewById(R.id.mydetails);
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateView();
    }

    public void populateView(){
        Container.removeAllViews();
        ArrayList<UserDetails>list=databaseHelper.GetUserList();

        Log.i("szi","size:"+list.size());
        for(int i=0;i<list.size();i++) {

            final UserDetails Details=list.get(i);
            View view= LayoutInflater.from(this).inflate(R.layout.details_layout,null);
            TextView firstname,lastname;
            firstname= (TextView) view.findViewById(R.id.FirstName);
            lastname= (TextView) view.findViewById(R.id.Address);
            firstname.setText(Details.firstname);
            lastname.setText(Details.address);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mydetails.this,Full_detail.class);
                    intent.putExtra("id",Details.id);
                    startActivity(intent);
                }
            });

            //TextView textView=new TextView(this);
            //textView.setText("FirstName:"+Details.firstname);
            Container.addView(view);
        }
        }
    }



package com.example.razzon.smarthealthpredictor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class UserInfoList extends AppCompatActivity {
    LinearLayout container;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_list);

        databaseHelper = new DatabaseHelper(this);
        container = (LinearLayout) findViewById(R.id.container);

    }

    @Override
    protected void onResume() {
        super.onResume();
        populateView();
    }

    public void populateView() {
        container.removeAllViews();
        ArrayList<UserDetails> list = databaseHelper.GetUserList();

        for (int i = 0; i < list.size(); i++) {

            //Setting runtime View
            TextView textView=new TextView(this);
            final UserDetails info=list.get(i);
            textView.setText(info.fullname+"\n"+info.address);

            //Inflate layout
            View view= LayoutInflater.from(this).inflate(R.layout.itemlayout,null);
            TextView Fullname,Address;

            Fullname= (TextView) view.findViewById(R.id.Fullname);
            Address= (TextView) view.findViewById(R.id.address);

            Fullname.setText(info.fullname);
            Address.setText(info.address);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(UserInfoList.this,FullDetails.class);
                    intent.putExtra("id",info.id);
                    startActivity(intent);
                }
            });

            container.addView(view);
        }
    }
}

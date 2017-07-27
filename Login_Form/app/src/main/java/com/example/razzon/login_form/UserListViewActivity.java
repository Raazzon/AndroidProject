package com.example.razzon.login_form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class UserListViewActivity extends AppCompatActivity {
    ListView listView;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_view);

        databaseHelper = new DatabaseHelper(this);

        listView = (ListView) findViewById(R.id.listview);
       listView.setAdapter(new UserListAdapter(this,databaseHelper.GetUserList()));
    }
}

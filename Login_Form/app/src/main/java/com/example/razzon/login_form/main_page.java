package com.example.razzon.login_form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.menu1:
                startActivity(new Intent(this,mydetails.class));
                break;
            case R.id.menu2:
                startActivity(new Intent(this,searchdiseases.class));

                break;
            case R.id.menu3:
                startActivity(new Intent(this,search_doctor.class));
                break;
            case R.id.menu4:
                startActivity(new Intent(this,feedback.class));
                break;
            case R.id.menu5:
                startActivity(new Intent(this,remainder.class));
                break;
            case R.id.menu6:
                startActivity(new Intent(this,main_login_activity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

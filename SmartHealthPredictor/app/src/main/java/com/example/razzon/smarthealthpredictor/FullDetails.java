package com.example.razzon.smarthealthpredictor;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FullDetails extends AppCompatActivity {
    String id;
    DatabaseHelper databaseHelper;
    TextView Id,fullname,username,password,address,phonenumber,age,email,gender;
    Button update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);

        id=getIntent().getStringExtra("id");

        databaseHelper=new DatabaseHelper(this);

        Id= (TextView) findViewById(R.id.ID);
        fullname= (TextView) findViewById(R.id.Fullname);
        username= (TextView) findViewById(R.id.UserName);
        password= (TextView) findViewById(R.id.Password);
        address= (TextView) findViewById(R.id.Address);
        phonenumber= (TextView) findViewById(R.id.Phone);
        age= (TextView) findViewById(R.id.Age);
        email= (TextView) findViewById(R.id.Email);
        gender= (TextView) findViewById(R.id.Gender);

        findViewById(R.id.Upadte).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FullDetails.this,RegistrationForm.class);
                intent.putExtra("id",Integer.parseInt(id));
                startActivity(intent);
            }
        });

        findViewById(R.id.Delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateViews();
    }

    public void populateViews(){
        UserDetails info=databaseHelper.GetUserInfo(id);
        Id.setText("Id:"+info.id);
        fullname.setText("FullName:"+info.fullname);
        username.setText("UserName:"+info.username);
        password.setText("Password:"+info.password);
        address.setText("Address:"+info.address);
        phonenumber.setText("PhoneNumber:"+info.phonenum);
        age.setText("Age:"+info.age);
        email.setText("Email:"+info.email);
        gender.setText("Gender:"+info.gender);

    }

    //Alert Message Before Delete
    public void showAlertDialog(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);

        dialog.setTitle("Delete User!!!");
        dialog.setMessage("Are You Sure?");

        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                databaseHelper.DeleteUser(id+"");
                finish();
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        dialog.show();
    }
}

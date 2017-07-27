package com.example.razzon.login_form;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Full_detail extends AppCompatActivity {
String id;
    DatabaseHelper databaseHelper;
    TextView Id,firstname, lastname, address, phonenumber, age, email, password, bloodgroup,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_detail);

        id=getIntent().getStringExtra("id");
        databaseHelper=new DatabaseHelper(this);
        Id= (TextView) findViewById(R.id.Id);
        firstname= (TextView) findViewById(R.id.firstname);
        lastname= (TextView) findViewById(R.id.lastname);
        address= (TextView) findViewById(R.id.address);
        phonenumber= (TextView) findViewById(R.id.phoneno);
        age= (TextView) findViewById(R.id.age);
        email= (TextView) findViewById(R.id.email);
        password= (TextView) findViewById(R.id.password);
        bloodgroup= (TextView) findViewById(R.id.bloodgroup);
        gender= (TextView) findViewById(R.id.gender);


        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Full_detail.this,register.class);
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
        UserDetails Details=databaseHelper.GetUserInfo(id);
        Id.setText("Id:"+Details.id);
        firstname.setText("FullName:"+Details.firstname);
        lastname.setText("UserName:"+Details.lastname);
        address.setText("Address"+Details.address);
        phonenumber.setText("PhoneNo:"+Details.phonenumber);
        age.setText("Age:"+Details.age);
        email.setText("Email:"+Details.email);
        password.setText("Password:"+Details.password);
        bloodgroup.setText("BloodGroup:"+Details.bloodgroup);
        gender.setText("Gender:"+Details.gender);
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

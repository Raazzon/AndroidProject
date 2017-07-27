package com.example.razzon.smarthealthpredictor;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistrationForm extends AppCompatActivity {

    EditText fullname,username,password,address,age,email,phonenumber;
    Button register,cancel,clear;
    RadioGroup gender;

    DatabaseHelper databaseHelper;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        databaseHelper=new DatabaseHelper(this);

        fullname= (EditText) findViewById(R.id.editfn);
        username= (EditText) findViewById(R.id.editUsername);
        password= (EditText) findViewById(R.id.editpass);
        address= (EditText) findViewById(R.id.editaddress);
        age= (EditText) findViewById(R.id.editage);
        phonenumber= (EditText) findViewById(R.id.editphoneno);
        email= (EditText) findViewById(R.id.editemail);
        gender = (RadioGroup) findViewById(R.id.gender);

        register= (Button) findViewById(R.id.btnregister);
        clear= (Button) findViewById(R.id.btnrclear);
        cancel= (Button) findViewById(R.id.btnrcancel);

        //Update garda id lera ahucha
        id = getIntent().getIntExtra("id", 0);
        //setting the value
        if (id > 0) {
            UserDetails info = databaseHelper.GetUserInfo(id + "");
            fullname.setText(info.fullname);
            username.setText(info.username);
            address.setText(info.address);
            phonenumber.setText(info.phonenum);
            age.setText(info.age);
            email.setText(info.email);
            password.setText(info.password);

            register = (Button) findViewById(R.id.btnregister);
            if (gender.equals("male")) {
                ((RadioButton) findViewById(R.id.male)).setChecked(true);
            } else
                ((RadioButton) findViewById(R.id.female)).setChecked(true);
            register.setText("Update");
        }


      /*  cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrationForm.this,LoginActivity.class);
                startActivity(intent);
            }
        });*/

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullname.setText("");
                username.setText("");
                password.setText("");
                address.setText("");
                phonenumber.setText("");
                age.setText("");
                email.setText("");
            }
        });
       /* cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrationForm rf=new RegistrationForm();
                FragmentManager manager=getSupportFragmentManager();
                manager.beginTransaction().replace(this,LoginFragment.class);
            }
        });*/

        findViewById(R.id.btnregister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullnameValue=fullname.getText().toString();
                String usernameValue=username.getText().toString();
                String passwordValue=password.getText().toString();
                String addressValue=address.getText().toString();
                String phonenumberValue=phonenumber.getText().toString();
                String ageValue=age.getText().toString();
                String emailValue=email.getText().toString();
                RadioButton checkedbtn = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkedbtn.getText().toString();



                ContentValues cv=new ContentValues();
                cv.put("Fullname",fullnameValue);
                cv.put("UserName",usernameValue);
                cv.put("Password",passwordValue);
                cv.put("Address",addressValue);
                cv.put("PhoneNo",phonenumberValue);
                cv.put("Age",ageValue);
                cv.put("Email",emailValue);
                cv.put("Gender",genderValue);


                if(id==0) {
                    databaseHelper.InsertUser(cv);
                    Toast.makeText(RegistrationForm.this, "User registered", Toast.LENGTH_LONG).show();
                }else {

                    databaseHelper.UpdateUser(cv,id+"");
                    Toast.makeText(RegistrationForm.this, "User Updated", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });

    }
}

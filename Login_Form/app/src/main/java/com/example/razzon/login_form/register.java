package com.example.razzon.login_form;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class register extends AppCompatActivity {
    EditText firstname, lastname, address, phonenumber, age, email, password, bloodgroup;
    Button register, cancel;

    ImageView imageView;
    RadioGroup gender;

    SharedPreferences preferences;

    DatabaseHelper databaseHelper;

    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        preferences = getSharedPreferences("UserInfo", 0);

        id = getIntent().getIntExtra("id", 0);

        databaseHelper = new DatabaseHelper(this);

        firstname = (EditText) findViewById(R.id.fname);
        lastname = (EditText) findViewById(R.id.lname);
        address = (EditText) findViewById(R.id.address);
        phonenumber = (EditText) findViewById(R.id.pnum);
        age = (EditText) findViewById(R.id.Age);
        password = (EditText) findViewById(R.id.password1);
        email = (EditText) findViewById(R.id.email);
        bloodgroup = (EditText) findViewById(R.id.bgroup);
        gender = (RadioGroup) findViewById(R.id.gender);

        imageView= (ImageView) findViewById(R.id.image);

        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this, main_login_activity.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,101);
            }
        });

        if (id > 0) {
            UserDetails Details = databaseHelper.GetUserInfo(id + "");
            firstname.setText(Details.firstname);
            lastname.setText(Details.lastname);
            address.setText(Details.address);
            phonenumber.setText(Details.phonenumber);
            age.setText(Details.age);
            email.setText(Details.email);
            password.setText(Details.password);
            bloodgroup.setText(Details.bloodgroup);

            register = (Button) findViewById(R.id.register);
            if (gender.equals("male")) {
                ((RadioButton) findViewById(R.id.male)).setChecked(true);
            } else
                ((RadioButton) findViewById(R.id.female)).setChecked(true);
            register.setText("Update");
        }

        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstnameValue = firstname.getText().toString();
                String lastnameValue = lastname.getText().toString();
                String addressValue = address.getText().toString();
                String phonenumberValue = phonenumber.getText().toString();
                String ageValue = age.getText().toString();
                String emailValue = email.getText().toString();
                String passwordValue = password.getText().toString();
                String bloodgroupValue = bloodgroup.getText().toString();
                RadioButton checkedbtn = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkedbtn.getText().toString();

              /* if (firstnameValue.length()+lastnameValue.length()
                        +addressValue.length()+phonenumberValue.length()
                        +ageValue.length()+emailValue.length()+passwordValue.length()+bloodgroupValue.length()==0){}*/

                   if (firstnameValue.length()==0){
                    firstname.setError("Enter FirstName");}
                   if (firstnameValue.length()==0){
                       lastname.setError("Enter UserName");
                   }if (firstnameValue.length()==0){
                       address.setError("Enter Address");}
                   if (firstnameValue.length()==0){
                       phonenumber.setError("Enter Phone Number");}
                   if (firstnameValue.length()==0){
                       age.setError("Enter Age");}
                   if (firstnameValue.length()==0){
                       email.setError("Enter Email");}
                   if (firstnameValue.length()==0){
                       password.setError("Enter Password");}
                   if (firstnameValue.length()==0){
                       bloodgroup.setError("Enter BloodGroup");}

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("firstname", firstnameValue);
                editor.putString("lastname", lastnameValue);
                editor.putString("address", addressValue);
                editor.putString("phonenumber", phonenumberValue);
                editor.putString("age", ageValue);
                editor.putString("email", emailValue);
                editor.putString("password", passwordValue);
                editor.putString("bloodgroup", bloodgroupValue);
                editor.apply();

                ContentValues cv = new ContentValues();

                cv.put("FirstName", firstnameValue);
                cv.put("LastName", lastnameValue);
                cv.put("Address", addressValue);
                cv.put("PhoneNo", phonenumberValue);
                cv.put("Age", ageValue);
                cv.put("Email", emailValue);
                cv.put("Password", passwordValue);
                cv.put("BloodGroup",bloodgroupValue);
                cv.put("Gender", genderValue);
                cv.put("Image",getBlob(bitmap));

                if (id == 0) {
                    databaseHelper.InsertUser(cv);
                    Toast.makeText(register.this, "User registered", Toast.LENGTH_LONG).show();
                }
                else {
                    databaseHelper.UpdateUser(cv,id+"");//Convert Integer into String:String.Value(id)
                    Toast.makeText(register.this, "User Updated", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

    }
Bitmap bitmap;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if (requestCode==101){
        bitmap=(Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    }
    public static byte[] getBlob(Bitmap bitmap){
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bos);
        byte[] bArray=bos.toByteArray();
        return bArray;
    }
    public static Bitmap getBitmap(byte[] byteArray){
        return BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
    }
}

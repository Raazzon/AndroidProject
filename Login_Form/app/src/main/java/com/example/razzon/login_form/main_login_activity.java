package com.example.razzon.login_form;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/*import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;*/

public class main_login_activity extends AppCompatActivity {

    EditText username, password;
    Button login, signup, clear;


    /// LoginButton loginButton;
    //CallbackManager callbackManager;

    SharedPreferences preferences;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createDatabase();

        //FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login);

        preferences = getSharedPreferences("UserInfo", 0);

       /* loginButton= (LoginButton) findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(main_login_activity.this, "Login Success "+ "", Toast.LENGTH_LONG).show();
                loginResult.getAccessToken().getUserId();
                loginResult.getAccessToken().getToken();
            }

            @Override
            public void onCancel() {

                Toast.makeText(main_login_activity.this, "Login Cancelled "+ "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException error) {

            }
        });*/


        login = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.Signup);
        clear = (Button) findViewById(R.id.clear);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        databaseHelper = new DatabaseHelper(this);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_login_activity.this, register.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = username.getText().toString();
                String Password = password.getText().toString();
                String registeredValue = preferences.getString("email", "") + preferences.getString("password", "");
               //
                //startActivity(intent);
                if (databaseHelper.IsLoginSuccessfull(User, Password)) {
                   // IsLoginSuccessfull(username.getText().toString(),password.getText().toString()))
                    //if (enteredValue.equals(registeredValue)
                    Intent intent = new Intent(main_login_activity.this, main_page.class);
                   // Intent intent = new Intent(main_login_activity.this,NavDrawer.class);
                    //intent = new Intent(main_login_activity.this, Full_detail.class);
                    
                    startActivity(intent);
                } else {
                    Toast.makeText(main_login_activity.this, "Login Failed " + registeredValue, Toast.LENGTH_LONG).show();

                }

                //Toast.makeText(main_login_activity.this, "Value:" + registeredValue, Toast.LENGTH_LONG).show();

            }
        });


    }

    //@Override
   /* protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }*/
    private void createDatabase() {
        try {
            boolean dbExist = checkDataBaseExist();
            System.out.println("database" + dbExist);
            Log.i("hamro", getPackageName());
            if (!dbExist) {
                String myDbDir = "/data/data" + getPackageName() + "/database";
                (new File(myDbDir)).mkdir();
                OutputStream dos =new FileOutputStream("/data/data" + getPackageName() + "/database"+DatabaseHelper.name);
                InputStream dis=getResources().openRawResource(R.raw.smarthealthpredictor);
                byte[] buffer=new byte[1024];
                int length;
                while ((length=dis.read(buffer))>0){
                    dos.write(buffer);
                }
                dos.flush();
                dos.close();
                dis.close();

            }
        } catch (Exception e) {
           // e.printStackTrace();
        }

    }

    private boolean checkDataBaseExist() {
        System.out.println("data");
        SQLiteDatabase checkDB = null;
        try {
            String myPath = "/data/data" + getPackageName() + "/database/" + DatabaseHelper.name;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            //databasehelper donot exist
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }
}

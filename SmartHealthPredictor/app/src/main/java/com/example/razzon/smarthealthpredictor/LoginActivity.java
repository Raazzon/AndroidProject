package com.example.razzon.smarthealthpredictor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView username,password;
    Button login, clear, signup;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        databaseHelper=new DatabaseHelper(this);

       // createDatabase();

        //Finding username and password by id
        username= (TextView) findViewById(R.id.editun);
        password= (TextView) findViewById(R.id.editpassword);

        //Finding button by id
        login= (Button) findViewById(R.id.btnlogin);
        clear= (Button) findViewById(R.id.btnclear);
        signup= (Button) findViewById(R.id.btnsignup);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName=username.getText().toString();
                String Password = password.getText().toString();
                if (databaseHelper.IsLoginSuccessfull(UserName, Password)) {
                    Intent intent = new Intent(LoginActivity.this,UserInfoList.class);
                    //intent = new Intent(LoginActivity.this, UserDetails.class);

                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed ", Toast.LENGTH_LONG).show();

                }

            }
        });

        //Setting on click listener in clear button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
            }
        });

        //Setting Onclick listener for signup button
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationForm.class);
                startActivity(intent);
            }
        });
    }


    //Using External DB
  /*  private void createDatabase() {
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
    }*/

}

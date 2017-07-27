package com.example.razzon.login_form;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegisterFragmemnt registerFragmemnt;
    RemainderFragment remainderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        loginFragment = new LoginFragment();
        registerFragmemnt = new RegisterFragmemnt();
        remainderFragment = new RemainderFragment();

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        transaction.replace(R.id.loginc,loginFragment);
        transaction.replace(R.id.registerc,registerFragmemnt);
        transaction.commit();
    }
}

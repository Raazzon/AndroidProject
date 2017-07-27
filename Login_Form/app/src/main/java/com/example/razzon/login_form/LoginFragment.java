package com.example.razzon.login_form;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by RAZZON on 4/17/2017.
 */

public class LoginFragment extends Fragment {

    TextView username,password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login,null);
        username= (TextView) view.findViewById(R.id.username);
        password= (TextView) view.findViewById(R.id.password);

        view.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view.findViewById(R.id.Signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),register.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

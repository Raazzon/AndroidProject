package com.example.razzon.smarthealthpredictor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by RAZZON on 5/31/2017.
 */

public class RegistrationFragment extends Fragment {
    EditText fullname, username, password, address, age, email, phonenumber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //View view = inflater.inflate(R.layout.activity_registration_form, null);
        View view=inflater.inflate(R.layout.activity_registration_form,container,false);

        view.findViewById(R.id.btnregister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view.findViewById(R.id.btnrcancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack("LoginFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });

        view.findViewById(R.id.btnclear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
            }
        });

        return view;

    }
}

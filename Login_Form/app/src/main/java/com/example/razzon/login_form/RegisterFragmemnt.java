package com.example.razzon.login_form;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by RAZZON on 4/17/2017.
 */

public class RegisterFragmemnt extends Fragment {

    EditText firstname, lastname, address, phonenumber, age, email, password, bloodgroup;
    Button register, cancel;
    RadioGroup gender;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.register,null);

        return view;
    }
}

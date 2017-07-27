package com.example.razzon.smarthealthpredictor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by RAZZON on 5/31/2017.
 */

public class LoginFragment extends Fragment{

    EditText Username, Password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_activity, null);
        Username = (EditText) view.findViewById(R.id.editun);
        Password = (EditText) view.findViewById(R.id.editpassword);

        view.findViewById(R.id.btnlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view.findViewById(R.id.btnsignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),RegistrationForm.class);
//                startActivity(intent);
              // getFragmentManager().beginTransaction().replace(R.id.main_fragment,RegistrationFragment.class).commit();
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.main_fragment, RegistrationFragment.class)
//                        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//                        .commit();
            }
        });

        return view;
    }

}



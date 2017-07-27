package com.example.razzon.login_form;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RAZZON on 4/3/2017.
 */

public class UserListAdapter extends ArrayAdapter<UserDetails> {

    Context context;
    DatabaseHelper databasehelper;
    public UserListAdapter(@NonNull Context context, ArrayList<UserDetails> list) {
        super(context, 0,list);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final UserDetails Details=getItem(position);
        View view= LayoutInflater.from(context).inflate(R.layout.details_layout,null);

        TextView firstname,lastname;
        firstname= (TextView) view.findViewById(R.id.FirstName);
        lastname= (TextView) view.findViewById(R.id.Address);

        firstname.setText(Details.firstname);
        lastname.setText(Details.address);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Full_detail.class);
                intent.putExtra("id",Details.id);
                context.startActivity(intent);
            }
        });


        return view;
    }
}

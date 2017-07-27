package com.example.razzon.login_form;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by RAZZON on 4/6/2017.
 */

public class SpinnerListAdapter extends ArrayAdapter<UserDetails> {
    Context context;
    public SpinnerListAdapter(@NonNull Context context,  ArrayList<UserDetails>list) {
        super(context, 0,list);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}

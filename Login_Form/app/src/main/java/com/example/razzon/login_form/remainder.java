package com.example.razzon.login_form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class remainder extends AppCompatActivity {

    Button setRemainder;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remainder);
        setRemainder = (Button) findViewById(R.id.sr);
        layout = (LinearLayout) findViewById(R.id.showlayout);

        setRemainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            layout.setVisibility(View.VISIBLE);
            }
        });
    }

}

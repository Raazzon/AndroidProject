package com.example.razzon.login_form;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private Switch switchBtn;
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    static MainActivity inst;

    public static MainActivity instance() {
        return inst;
    }

    @Override
    protected void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        switchBtn = (Switch) findViewById(R.id.switch1);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        timePicker.setIs24HourView(true);

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked) {
                   switchBtn.setText("ON");
                   Calendar calendar = Calendar.getInstance();
                   calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                   calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                   Intent myIntent = new Intent(MainActivity.this, AlarmReceiver.class);
                   pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);
                   alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
               } else {
                   alarmManager.cancel(pendingIntent);
                   switchBtn.setText("OFF");
               }
            }
        });
    }

    public static void showDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(inst);
        adb.setTitle(inst.getString(R.string.app_name))
                .setMessage("Wake Up!")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog dialog = adb.create();
        dialog.show();
    }
}

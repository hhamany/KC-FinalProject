package com.example.myproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject2.databinding.ActivityAddMedBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import org.w3c.dom.Text;

import java.util.Calendar;

public class AddMed extends AppCompatActivity {

    private ActivityAddMedBinding binding;
    private MaterialTimePicker picker;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddMedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createNotificationChannel();

    binding.alarm1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        showTimePicker();

    }
});

        binding.set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setAlarm();

            }
        });

    }

    private void setAlarm() {

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this,Alarm.class);

        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,pendingIntent);

        Toast.makeText(this, "Alarm set Successfully", Toast.LENGTH_SHORT).show();



    }

    private void showTimePicker() {

        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();

        picker.show(getSupportFragmentManager(),"foxandroid");

        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (picker.getHour() > 12){

                    binding.timeshow1.setText(
                            String.format("%02d",(picker.getHour()-12))+" : "+String.format("%02d",picker.getMinute())+" PM"
                    );

                }else {

                    binding.timeshow1.setText(picker.getHour()+" : " + picker.getMinute() + " AM");

                }

                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,picker.getHour());
                calendar.set(Calendar.MINUTE,picker.getMinute());
                calendar.set(Calendar.SECOND,0);
                calendar.set(Calendar.MILLISECOND,0);

            }
        });


    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "set alarm";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("medAlarm",name,importance);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }





    EditText name = findViewById(R.id.addedmedname);
        EditText size = findViewById(R.id.medsize);
        EditText medextra = findViewById(R.id.medextra);
        TextView time1 = findViewById(R.id.timeshow1);
        Button okbtn = findViewById(R.id.done);


        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Mymedicines newmedicine = new Mymedicines(
                        name.getText().toString() ,
                        size.getText().toString(),
                        medextra.getText().toString(),
                        time1.getText().toString());
                        Intent intent = new Intent(AddMed.this,MyList.class);
                        intent.putExtra("newmedicine", newmedicine);
                        startActivity(intent);
            }
        });

    }

}

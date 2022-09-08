package com.example.myproject2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject2.databinding.ActivityAddMedBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class AddMed extends AppCompatActivity {

            private ActivityAddMedBinding binding;
            private MaterialTimePicker picker;
            private Calendar calendar;
            private AlarmManager alarmManager;
            private PendingIntent pendingIntent;
            Button set;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_add_med);

                EditText name = findViewById(R.id.addedmedname);
                EditText size = findViewById(R.id.medsize);
                EditText medextra = findViewById(R.id.medextra);
                Button okbtn = findViewById(R.id.done);

                okbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Mymedicines newmedicine = new Mymedicines(
                                name.getText().toString(),
                                size.getText().toString(),
                                medextra.getText().toString()) ;
                        Intent intent = new Intent(AddMed.this, MyList.class);
                        intent.putExtra("newmedicine", newmedicine);
                        startActivity(intent);
                    }
                });


                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

                set = findViewById(R.id.alarm1);

                set.setOnClickListener(view -> {

                    MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_24H)
                            .setHour(12)
                            .setMinute(0)
                            .setTitleText("make alarm")
                            .build();
                    materialTimePicker.addOnPositiveButtonClickListener(view1 -> {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                        calendar.set(Calendar.MINUTE, materialTimePicker.getMinute());
                        calendar.set(Calendar.HOUR_OF_DAY, materialTimePicker.getHour());

                        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(calendar.getTimeInMillis(), getAlarmPendingIntent());
                        alarmManager.setAlarmClock(alarmClockInfo,getAlarmAction());
                        Toast.makeText(this, "تم عمل منبه "+simpleDateFormat.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
                    });
                    materialTimePicker.show(getSupportFragmentManager(), "alarm");

                });
            }

            private PendingIntent getAlarmPendingIntent() {

                Intent alarmintent = new Intent(this, AddMed.class);
                alarmintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                return PendingIntent.getActivity(this, 0, alarmintent, PendingIntent.FLAG_UPDATE_CURRENT);

            }

            private PendingIntent getAlarmAction(){
                Intent intent = new Intent(this , Alarm.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                return PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                }
            }



package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ArrowKeyMovementMethod;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSlot extends AppCompatActivity {
CalendarView calendar;
TextView tv;
String service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);
        calendar=(CalendarView)findViewById(R.id.calendarView);
        tv=(TextView)findViewById(R.id.textView5);
        tv.setMovementMethod(ArrowKeyMovementMethod.getInstance());
       
        final Booking b=getIntent().getParcelableExtra("parcel_data");
        service=text(b.getW_id());
        tv.setText("Choose the date of "+service);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view,int year,int month, int dayOfMonth)
            {
                String date=dayOfMonth+"/"+(month+1)+"/"+year;
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date1, date2;
                try {
                    date1 = new Date();
                    date2 = dateFormat.parse(date);
                    if(date1.compareTo(date2)>=0)
                    {
                        Toast.makeText(TimeSlot.this, "Invalid Date Selection!",
                                Toast.LENGTH_LONG).show();
                        date="invalid";
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                b.setDate_st(date);
                Intent intent = new Intent(view.getContext(), TimeSlot2.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);

            }
        });
    }
    public String text(String id)
    {
        switch(id)
        {
            case "P1":
            case "P2":
            case "P3":return "Plumbing";
            case "E1":
            case "E2":
            case "E3":return "Electrical repair work";
            case "C1":
            case "C2":
            case "C3":return "Carpentry";
            case "PA1":
            case "PA2":
            case "PA3":return "Painting";
            case "PH1":
            case "PH2":
            case "PH3":return "Photography";
            default:return "Invalid Worker ID! Contact Developer.";

        }
    }

}

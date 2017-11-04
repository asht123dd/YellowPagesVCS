package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSlot extends AppCompatActivity {
CalendarView calendar;
    //long date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);
        calendar=(CalendarView)findViewById(R.id.calendarView);
        //date=calendar.getDate();
        final Booking b=(Booking)getIntent().getParcelableExtra("parcel_data");
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view,int year,int month, int dayOfMonth)
            {
                calendar.setMinDate(System.currentTimeMillis());
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

                int d=dayOfMonth;

                b.setDate_st(date);
               // curDate=String.valueOf(d);
                Intent intent = new Intent(view.getContext(), TimeSlot2.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);

            }
        });
    }

}

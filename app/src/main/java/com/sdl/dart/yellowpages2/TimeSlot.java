package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

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
                int d=dayOfMonth;
                String date=dayOfMonth+"/"+month+"/"+year;
                b.setDate_st(date);
               // curDate=String.valueOf(d);
                Intent intent = new Intent(view.getContext(), TimeSlot2.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);

            }
        });
    }

}

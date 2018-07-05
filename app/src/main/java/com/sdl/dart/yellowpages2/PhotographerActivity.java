package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by team dart on 5/10/17.
 */

public class PhotographerActivity extends AppCompatActivity {
    Button book_ph1, book_ph2,book_ph3;
    DatabaseHandler db;
    Booking b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photographer);
        db = new DatabaseHandler(this);
        book_ph1=(Button)findViewById(R.id.book_ph1);
        book_ph2=(Button)findViewById(R.id.book_ph2);
        book_ph3=(Button)findViewById(R.id.book_ph3);
        book_ph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("PH1");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_ph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("PH2");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_ph3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("PH3");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });

    }
}

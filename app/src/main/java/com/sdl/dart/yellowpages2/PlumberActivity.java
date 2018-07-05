package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlumberActivity extends AppCompatActivity{
Button book_p1, book_p2, book_p3;
    DatabaseHandler db;
    Booking b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plumber);
        db = new DatabaseHandler(this);
        book_p1=(Button)findViewById(R.id.book_p1);
        book_p2=(Button)findViewById(R.id.book_p2);
        book_p3=(Button)findViewById(R.id.book_p3);
        book_p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("P1");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("P2");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("P3");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });

    }
}

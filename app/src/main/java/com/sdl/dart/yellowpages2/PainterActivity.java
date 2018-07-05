package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PainterActivity extends AppCompatActivity {
    Button book_pa1, book_pa2,book_pa3;
    DatabaseHandler db;
    Booking b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painter);
        db = new DatabaseHandler(this);
        book_pa1=(Button)findViewById(R.id.book_pa1);
        book_pa2=(Button)findViewById(R.id.book_pa2);
        book_pa3=(Button)findViewById(R.id.book_pa3);
        book_pa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("PA1");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_pa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("PA2");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_pa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("PA3");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });

    }
}

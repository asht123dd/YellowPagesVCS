package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarpenterActivity extends AppCompatActivity {
Button book_c1, book_c2, book_c3;
    DatabaseHandler db;
    Booking b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpenter);
        db = new DatabaseHandler(this);
        book_c1=(Button)findViewById(R.id.book_c1);
        book_c2=(Button)findViewById(R.id.book_c2);
        book_c3=(Button)findViewById(R.id.book_c3);
        book_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("C1");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("C2");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("C3");
               /* ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");*/
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });

    }
}

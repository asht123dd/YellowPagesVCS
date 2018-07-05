package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ElectricianActivity extends AppCompatActivity {
Button book_e1, book_e2, book_e3;
    DatabaseHandler db;
    Booking b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electrician);
        db = new DatabaseHandler(this);
        book_e1=(Button)findViewById(R.id.book_e1);
        book_e2=(Button)findViewById(R.id.book_e2);
        book_e3=(Button)findViewById(R.id.book_e3);
        book_e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("E1");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("E2");
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("E3");
               /* ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");*/
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });

    }

}

package com.sdl.dart.yellowpages2;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CarpenterActivity extends AppCompatActivity implements ConfirmationDialog.ConfirmationDialogListener{
Button book_c1, book_c2, book_c3;
    int x;
    DatabaseHandler db;
    Booking b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpenter);
        db = new DatabaseHandler(this);
       // back=(Button)findViewById(R.id.back);
        book_c1=(Button)findViewById(R.id.book_c1);
        book_c2=(Button)findViewById(R.id.book_c2);
        book_c3=(Button)findViewById(R.id.book_c3);
        book_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=1;
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("C1");
               /* ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");*/
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=2;
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("C2");
               /* ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");*/
                Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=3;
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
    @Override
    public void onConfirmButtonClick(DialogFragment dialog) {
        if(x==1)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"C1"));
        }
        else if(x==2)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"C2"));
        }
        else if(x==3)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"C3"));
        }
        Toast.makeText(getApplicationContext(),"Booking Confirmed!",Toast.LENGTH_LONG).show();




    }
}

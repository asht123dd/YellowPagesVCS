package com.sdl.dart.yellowpages2;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlumberActivity extends AppCompatActivity implements ConfirmationDialog.ConfirmationDialogListener{
Button book_p1, book_p2, book_p3;
    DatabaseHandler db;
    int x;
    Booking b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plumber);
        db = new DatabaseHandler(this);
       // back=(Button)findViewById(R.id.back);
        book_p1=(Button)findViewById(R.id.book_p1);
        book_p2=(Button)findViewById(R.id.book_p2);
        book_p3=(Button)findViewById(R.id.book_p3);
        book_p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=1;
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("P1");
               /* ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");*/
               Intent intent=new Intent(v.getContext(),TimeSlot.class);
                intent.putExtra("parcel_data",b);
                startActivity(intent);
            }
        });
        book_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=2;
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
                x=3;
                b=new Booking();
                b.setU_name(MyApplication.getSomeVariable());
                b.setW_id("P3");
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
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"P1"));
        }
        else if(x==2)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"P2"));
        }
        else if(x==3)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"P3"));
        }
        Toast.makeText(getApplicationContext(),"Booking Confirmed!",Toast.LENGTH_LONG).show();




    }

}

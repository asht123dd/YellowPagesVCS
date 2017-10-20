package com.sdl.dart.yellowpages2;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TimeSlot2 extends AppCompatActivity implements ConfirmationDialog.ConfirmationDialogListener{
    Button b10_11, b11_12, b12_1, b1_2, b2_3, b3_4, b4_5, b5_6, b6_7;
    String w_id, time_st;
    String date_st;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot2);
        db = new DatabaseHandler(this);
        final Booking b=(Booking)getIntent().getParcelableExtra("parcel_data");
        w_id=b.getW_id();

        date_st=b.getDate_st();
        b1_2=(Button)findViewById(R.id.b1_2);
        b2_3=(Button)findViewById(R.id.b2_3);
        b3_4=(Button)findViewById(R.id.b3_4);
        b4_5=(Button)findViewById(R.id.b4_5);
        b5_6=(Button)findViewById(R.id.b5_6);
        b6_7=(Button)findViewById(R.id.b6_7);
        b10_11=(Button)findViewById(R.id.b10_11);
        b11_12=(Button)findViewById(R.id.b11_12);
        b12_1=(Button)findViewById(R.id.b12_1);
        b10_11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("10-11 AM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        b11_12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("11-12 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        b12_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("12-1 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        b1_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("1-2 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        b2_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("2-3 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        b3_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("3-4 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        b4_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("4-5 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        b5_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("5-6 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        b6_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("6-7 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });

    }
    @Override
    public void onConfirmButtonClick(DialogFragment dialog) {
            Booking b=new Booking(MyApplication.getSomeVariable(),w_id,date_st,time_st);
            if(b==null)
                Toast.makeText(TimeSlot2.this, "Everything is NULL!!!!",
                        Toast.LENGTH_LONG).show();
            else
            db.addNewBooking(b);

        Toast.makeText(getApplicationContext(),"Booking Confirmed!",Toast.LENGTH_LONG).show();




    }
}

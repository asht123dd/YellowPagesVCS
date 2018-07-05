package com.sdl.dart.yellowpages2;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ArrowKeyMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TimeSlot2 extends AppCompatActivity implements ConfirmationDialog.ConfirmationDialogListener{
    Button b10_11, b11_12, b12_1, b1_2, b2_3, b3_4, b4_5, b5_6, b6_7;
    String w_id, time_st;
    String date_st, service;
    DatabaseHandler db;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot2);
        tv=(TextView)findViewById(R.id.textView6);
        tv.setMovementMethod(ArrowKeyMovementMethod.getInstance());
        db = new DatabaseHandler(this);
        final Booking b=getIntent().getParcelableExtra("parcel_data");
        service=text(b.getW_id());
        tv.setText("Choose the time slot for "+service);
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
                ConfirmationDialog dialog = newInstance(b.getW_id(),b.getDate_st(),b.getTime_st());
                dialog.show(getFragmentManager(), "1");
            }
        });
        b11_12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("11-12 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = newInstance(b.getW_id(),b.getDate_st(),b.getTime_st());
                dialog.show(getFragmentManager(), "1");
            }
        });
        b12_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("12-1 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = newInstance(b.getW_id(),b.getDate_st(),b.getTime_st());
                dialog.show(getFragmentManager(), "1");
            }
        });
        b1_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("1-2 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = newInstance(b.getW_id(),b.getDate_st(),b.getTime_st());
                dialog.show(getFragmentManager(), "1");
            }
        });
        b2_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("2-3 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = newInstance(b.getW_id(),b.getDate_st(),b.getTime_st());
                dialog.show(getFragmentManager(), "1");
            }
        });
        b3_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("3-4 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = newInstance(b.getW_id(),b.getDate_st(),b.getTime_st());
                dialog.show(getFragmentManager(), "1");
            }
        });
        b4_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("4-5 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = newInstance(b.getW_id(),b.getDate_st(),b.getTime_st());
                dialog.show(getFragmentManager(), "1");
            }
        });
        b5_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("5-6 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = newInstance(b.getW_id(),b.getDate_st(),b.getTime_st());
                dialog.show(getFragmentManager(), "1");
            }
        });
        b6_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b.setTime_st("6-7 PM");
                time_st=b.getTime_st();
                ConfirmationDialog dialog = newInstance(b.getW_id(),b.getDate_st(),b.getTime_st());
                dialog.show(getFragmentManager(), "1");
            }
        });

    }
    public String text(String id)
    {
        switch(id)
        {
            case "P1":
            case "P2":
            case "P3":return "Plumbing";
            case "E1":
            case "E2":
            case "E3":return "Electrical repair work";
            case "C1":
            case "C2":
            case "C3":return "Carpentry";
            case "PA1":
            case "PA2":
            case "PA3":return "Painting";
            case "PH1":
            case "PH2":
            case "PH3":return "Photography";
            default:return "Invalid Worker ID! Contact Developer.";

        }
    }
    @Override
    public void onConfirmButtonClick(DialogFragment dialog) {
            Booking b=new Booking(MyApplication.getSomeVariable(),w_id,date_st,time_st);
            db.addNewBooking(b);

        Toast.makeText(getApplicationContext(),"Booking Confirmed!",Toast.LENGTH_LONG).show();




    }
    public static ConfirmationDialog newInstance(String worker,String date,String time) {
        ConfirmationDialog f = new ConfirmationDialog();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putString("W_ID", worker);
        args.putString("Date", date);
        args.putString("Time", time);
        f.setArguments(args);

        return f;
    }
}

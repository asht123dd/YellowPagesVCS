package com.sdl.dart.yellowpages2;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ashutosh on 5/10/17.
 */

public class PhotographerActivity extends AppCompatActivity implements ConfirmationDialog.ConfirmationDialogListener {
    Button back, book_ph1, book_ph2,book_ph3;
    DatabaseHandler db;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photographer);
        db = new DatabaseHandler(this);
        back=(Button)findViewById(R.id.back);
        book_ph1=(Button)findViewById(R.id.book_ph1);
        book_ph2=(Button)findViewById(R.id.book_ph2);
        book_ph3=(Button)findViewById(R.id.book_ph3);
        book_ph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=1;
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        book_ph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=2;
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "2");
            }
        });
        book_ph3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=3;
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "3");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Choice.class);
               /* EditText editText = (EditText) findViewById(R.id.editText3);
                EditText editText2 = (EditText) findViewById(R.id.editText4);
                u.setU_name(editText.getText().toString());
                u.setPass(editText2.getText().toString());
                if (db.searchUser(u))*/

                //intent.putExtra(message,message2);
                startActivity(intent);
               /* else {
                    Toast.makeText(MainActivity.this, "Invalid Credentials!",
                            Toast.LENGTH_LONG).show();
                }*/


            }
        });
    }
    @Override
    public void onConfirmButtonClick(DialogFragment dialog) {
        if(x==1)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"PH1"));
        }
        else if(x==2)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"PH2"));
        }
        else if(x==3)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"PH3"));
        }
        Toast.makeText(getApplicationContext(),"Booking Confirmed!",Toast.LENGTH_LONG).show();




    }
}

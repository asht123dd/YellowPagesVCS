package com.sdl.dart.yellowpages2;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ElectricianActivity extends AppCompatActivity implements ConfirmationDialog.ConfirmationDialogListener{
Button back, book_e1, book_e2, book_e3;
    DatabaseHandler db;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electrician);
        db = new DatabaseHandler(this);
        back=(Button)findViewById(R.id.back);
        book_e1=(Button)findViewById(R.id.book_e1);
        book_e2=(Button)findViewById(R.id.book_e2);
        book_e3=(Button)findViewById(R.id.book_e3);
        book_e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=1;
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "1");
            }
        });
        book_e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=2;
                ConfirmationDialog dialog = new ConfirmationDialog();
                dialog.show(getFragmentManager(), "2");
            }
        });
        book_e3.setOnClickListener(new View.OnClickListener() {
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
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"E1"));
        }
        else if(x==2)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"E2"));
        }
        else if(x==3)
        {
            db.addNewBooking(new Booking(MyApplication.getSomeVariable(),"E3"));
        }
        Toast.makeText(getApplicationContext(),"Booking Confirmed!",Toast.LENGTH_LONG).show();




    }
}

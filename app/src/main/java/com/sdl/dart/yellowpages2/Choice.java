package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.Toast;


public class Choice extends Activity {
Button btnPlumber, btnElectrician, btnCarpenter, btnPainter, btnPhotographer;
    //private String TAG = "Plumbers", TAG2="Electricians", TAG3="Carpenters", TAG4="Painters", TAG5="Photographers";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        btnPainter=(Button)findViewById(R.id.button7);
btnPlumber=(Button)findViewById(R.id.button4) ;
        btnElectrician=(Button)findViewById(R.id.button5);
       btnCarpenter=findViewById(R.id.carpenter);
        if(btnCarpenter==null)
            Toast.makeText(Choice.this, "Everything is NULL!",
                    Toast.LENGTH_LONG).show();
        btnPhotographer=(Button) findViewById(R.id.button8);
        btnPhotographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PhotographerActivity.class);
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
        btnPlumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlumberActivity.class);
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
        btnElectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ElectricianActivity.class);
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
       btnCarpenter.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent = new Intent(v.getContext(), CarpenterActivity.class);
               /* EditText editText = (EditText) findViewById(R.id.editText3);
                EditText editText2 = (EditText) findViewById(R.id.editText4);
                u.setU_name(editText.getText().toString());
                u.setPass(editText2.getText().toString());
                if (db.searchUser(u))*/

               //intent.putExtra(message,message2);
               startActivity(intent);
           }
       });
        btnPainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PainterActivity.class);
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Floating action button features not yet defined", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void intenter(View v,Class clas)
    {
        Intent intent = new Intent(v.getContext(),clas);

        startActivity(intent);
    }

}

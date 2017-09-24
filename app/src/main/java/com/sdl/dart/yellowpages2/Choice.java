package com.sdl.dart.yellowpages2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Choice extends AppCompatActivity implements PlumberList.PlumberListListener{
Button btnPlumber;
    private String TAG = "Plumbers";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
btnPlumber=(Button)findViewById(R.id.button4) ;
        btnPlumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PlumberList dialog = new PlumberList();
                dialog.show(getFragmentManager(), TAG);
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

}

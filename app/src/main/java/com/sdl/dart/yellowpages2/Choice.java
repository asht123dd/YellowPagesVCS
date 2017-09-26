package com.sdl.dart.yellowpages2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Choice extends AppCompatActivity implements PlumberList.PlumberListListener,ElectricianList.ElectricianListListener,CarpenterList.CarpenterListListener,PainterList.PainterListListener{
Button btnPlumber, btnElectrician, btnCarpenter, btnPainter;
    private String TAG = "Plumbers", TAG2="Electricians", TAG3="Carpenters", TAG4="Painters";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        btnPainter=(Button)findViewById(R.id.button7);
btnPlumber=(Button)findViewById(R.id.button4) ;
        btnElectrician=(Button)findViewById(R.id.button5);
        btnCarpenter=(Button)findViewById(R.id.button6);
        btnCarpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CarpenterList dialog = new CarpenterList();
                dialog.show(getFragmentManager(), TAG3);
            }
        });
        btnPainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PainterList dialog = new PainterList();
                dialog.show(getFragmentManager(), TAG4);
            }
        });

        btnElectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ElectricianList dialog = new ElectricianList();
                dialog.show(getFragmentManager(), TAG2);
            }
        });
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

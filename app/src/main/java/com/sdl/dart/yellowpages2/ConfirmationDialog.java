package com.sdl.dart.yellowpages2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ArrowKeyMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ashutosh on 5/10/17.
 */

public class ConfirmationDialog extends DialogFragment {
    TextView tv;
    String worker, date, time;
    interface ConfirmationDialogListener{

        void onConfirmButtonClick(DialogFragment dialog);
       // void onCancelButtonClick(DialogFragment dialog);

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
    //create an Instance to deliever the action
    ConfirmationDialog.ConfirmationDialogListener confirmListener;
    Context context;

    // Override the Fragment.onAttach() method to instantiate the SetPasswordDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the SetPasswordDialogListener so we can send events to the host
            confirmListener = (ConfirmationDialog.ConfirmationDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement ConfirmationDialogListener");
        }
    }
    //END
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        worker= getArguments().getString("W_ID");
        date= getArguments().getString("Date");
        time= getArguments().getString("Time");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.confirmation, container, false);
        View tv = v.findViewById(R.id.textView4);
        ((TextView)tv).setText("Book "+text(worker)+" on "+date+" in time slot "+time);
        //final AlertDialog OptionDialog = new AlertDialog.Builder(this).create();

        // Watch for button clicks.
        Button button = (Button)v.findViewById(R.id.button9);
        Button no=(Button)v.findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.
                confirmListener.onConfirmButtonClick(ConfirmationDialog.this);
                ConfirmationDialog.this.getDialog().cancel();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.
                ConfirmationDialog.this.getDialog().cancel();
            }
        });


        return v;
    }

    public void changeTextView()
    {
        tv=(TextView) getDialog().findViewById(R.id.textView4);

    }

    public String text(String id)
    {
        switch(id)
        {
            case "P1":
            case "P2":
            case "P3":return "Plumber";
            case "E1":
            case "E2":
            case "E3":return "Electrician ";
            case "C1":
            case "C2":
            case "C3":return "Carpenter";
            case "PA1":
            case "PA2":
            case "PA3":return "Painter";
            case "PH1":
            case "PH2":
            case "PH3":return "Photographer";
            default:return "Invalid Worker ID! Contact Developer.";

        }
    }
}

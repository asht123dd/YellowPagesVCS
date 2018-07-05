package com.sdl.dart.yellowpages2;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by team dart on 5/10/17.
 */

public class ConfirmationDialog extends DialogFragment {
    String worker, date, time, displaytext;
    interface ConfirmationDialogListener{

        void onConfirmButtonClick(DialogFragment dialog);
    }
    //create an Instance to deliver the action
    ConfirmationDialog.ConfirmationDialogListener confirmListener;

    // Override the Fragment.onAttach() method to instantiate the ConfirmationDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the ConfirmationDialogListener so we can send events to the host
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
        displaytext="Book "+text(worker)+" on "+date+" in time slot "+time;
        ((TextView)tv).setText(displaytext);
        // Watch for button clicks.
        Button button = v.findViewById(R.id.button9);
        Button no=v.findViewById(R.id.button10);
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

package com.sdl.dart.yellowpages2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Created by ashutosh on 5/10/17.
 */

public class ConfirmationDialog extends DialogFragment {
    interface ConfirmationDialogListener{

        void onConfirmButtonClick(DialogFragment dialog);
       // void onCancelButtonClick(DialogFragment dialog);

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
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.confirmation, null))

                // Add action buttons
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        confirmListener.onConfirmButtonClick(ConfirmationDialog.this);

                    }
                })
               .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ConfirmationDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
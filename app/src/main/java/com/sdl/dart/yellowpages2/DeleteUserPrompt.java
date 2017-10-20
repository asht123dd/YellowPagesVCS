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
 * Created by ashutosh on 20/10/17.
 */

public class DeleteUserPrompt extends DialogFragment {
    interface DeleteUserPromptListener{
        void onHomeClick(DialogFragment dialog);
    }
    //create an Instance to deliever the action
    DeleteUserPrompt.DeleteUserPromptListener deleteUserPromptListener;
    Context context;
    // Override the Fragment.onAttach() method to instantiate the SetPasswordDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the SetPasswordDialogListener so we can send events to the host
            deleteUserPromptListener = (DeleteUserPrompt.DeleteUserPromptListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement DeleteUserPromptListener");
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
        builder.setView(inflater.inflate(R.layout.prompt, null))

                // Add action buttons
                .setPositiveButton(R.string.home, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        deleteUserPromptListener.onHomeClick(DeleteUserPrompt.this);

                    }
                })
            /*    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ConfirmationDialog.this.getDialog().cancel();
                    }
                })*/;
        return builder.create();
    }

}

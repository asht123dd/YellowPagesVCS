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
 * Created by ashutosh on 24/9/17.
 */

public class PlumberList extends DialogFragment {
    interface PlumberListListener{

      //  void onSaveButtonClick(DialogFragment dialog);
        //void onCancelButtonClick(DialogFragment dialog);

    }
    //create an Instance to deliever the action
    PlumberList.PlumberListListener showPlumbersListener;
    Context context;

    // Override the Fragment.onAttach() method to instantiate the SetPasswordDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the SetPasswordDialogListener so we can send events to the host
            showPlumbersListener = (PlumberList.PlumberListListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement PlumberListListener");
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
        builder.setView(inflater.inflate(R.layout.plumber, null));
        return builder.create();
    }
}

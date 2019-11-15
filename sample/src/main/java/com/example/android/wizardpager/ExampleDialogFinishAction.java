package com.example.android.wizardpager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.atech.android.library.wizardpager.defs.action.AbstractFinishAction;

public class ExampleDialogFinishAction extends AbstractFinishAction {

    FragmentManager fragmentManager;

    public ExampleDialogFinishAction(FragmentManager fragmentManager) {

        this.fragmentManager = fragmentManager;
    }



    @Override
    public void execute() {
        DialogFragment dg = new DialogFragment() {
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                return new AlertDialog.Builder(getActivity())
                        .setMessage(R.string.submit_confirm_message)
                        .setPositiveButton(
                                R.string.submit_confirm_button,
                                null)
                        .setNegativeButton(android.R.string.cancel,
                                null).create();
            }
        };
        dg.show(this.fragmentManager, "place_order_dialog");

    }
}

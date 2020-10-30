/*Name: Runsewe Oluwayemisi
 * Class: Mobile Development - Android
 * Assignment: Program 6 - Use of dialogs
 */
package com.example.program6;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class LengthDialogFragment extends DialogFragment {

    //Create LengthCall Back Interface
    public interface LengthCallBack {
        void pickLength(int i);
    }

    private LengthDialogFragment.LengthCallBack activity;

    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (LengthDialogFragment.LengthCallBack) context;
    }

    /**
     * Create Aleart Dialog and the onclick instance for the dialog
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose Length");
        builder.setItems(R.array.length_menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    activity.pickLength(i);
            }
        });

        return builder.create();
    }
}

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

public class ColorDialogFragment extends DialogFragment {

    //Create Color call back inteface
    public interface ColorCallBack {
        void pickColor(int i);
    }

    private ColorCallBack activity;

    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (ColorCallBack) context;
    }

    /**
     * Create Aleart Dialog and the onclick instance for the dialog
     */

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose a  color");
        builder.setItems(R.array.color_menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.pickColor(i);
            }
        });

        return builder.create();
    }
}

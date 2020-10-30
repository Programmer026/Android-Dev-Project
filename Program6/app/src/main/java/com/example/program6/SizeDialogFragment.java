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

public class SizeDialogFragment extends DialogFragment {
    //Create Call Back interface
    public interface SizeCallBack {
        void pickSize(int i);
    }

    private SizeDialogFragment.SizeCallBack activity;

    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (SizeDialogFragment.SizeCallBack) context;
    }

    /**
     * Create Aleart Dialog and the onclick instance for the dialog
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose a Size");
        builder.setItems(R.array.size_menu, (dialogInterface, i) -> activity.pickSize(i));

        return builder.create();
    }
}

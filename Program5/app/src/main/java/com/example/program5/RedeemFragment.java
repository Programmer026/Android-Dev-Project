/*Name: Oluwayemisi Runsewe
Class: Mobile Computing Android Development
Assignment: Program 5 - Gift Card Counter
* */
package com.example.program5;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RedeemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RedeemFragment extends Fragment {

    public interface RedeemCallBack {
        void update();
        void swapToPurchase();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String REDEEMED_CODE = "REDEEMED_CODE";

    // TODO: Rename and change types of parameters
    private int redeemedCode;


    private RedeemFragment.RedeemCallBack myActivity;

    public void onAttach(Context context) {
        super.onAttach(context);
        myActivity = (RedeemCallBack) context;
    }

    private GiftCardModel giftCardModel;
    public RedeemFragment() {
        // Required empty public constructor
        giftCardModel = GiftCardModel.getSingleton();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RedeemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RedeemFragment newInstance( int rWorth) {
        RedeemFragment fragment = new RedeemFragment();
        Bundle args = new Bundle();
        args.putInt(REDEEMED_CODE, rWorth);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            redeemedCode = getArguments().getInt(REDEEMED_CODE, 0);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vf = inflater.inflate(R.layout.fragment_redeem, container, false);

        Button redeemBTN = vf.findViewById(R.id.redeemBTN);
        redeemBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText redeemET = vf.findViewById(R.id.redeemET);
                try {
                    redeemedCode = Integer.parseInt(redeemET.getText().toString());
                } catch (NumberFormatException e) {
                    redeemedCode = -1;
                }
                redeemET.setText("");
                if(giftCardModel.redeemCard(redeemedCode) == true){
                    Toast.makeText(getContext(), "Redeem Was Sucessful\nMessage: " + giftCardModel.getTheMessage(redeemedCode), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Redeem was not Sucessful or Card has already been redeemed", Toast.LENGTH_LONG).show();
                }
                myActivity.update();
            }
        });

        Button toPurchaseBTN = vf.findViewById(R.id.toPurchaseBTN);
        toPurchaseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myActivity.swapToPurchase();
            }
        });

        return vf;
    }
}
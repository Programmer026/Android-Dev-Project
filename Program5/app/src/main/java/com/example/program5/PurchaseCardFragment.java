/*Name: Oluwayemisi Runsewe
Class: Mobile Computing Android Development
Assignment: Program 5 - Gift Card Counter
* */
package com.example.program5;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PurchaseCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PurchaseCardFragment extends Fragment {

    public interface PurchaseCallBack {
        void update();
        void swapToRedeem();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PURCHASE_WORTH = "PURCHASE_WORTH";

    // TODO: Rename and change types of parameters
    private double purchaseWorth;


    private PurchaseCardFragment.PurchaseCallBack myActivity;

    public void onAttach(Context context) {
        super.onAttach(context);
        myActivity = (PurchaseCardFragment.PurchaseCallBack) context;
    }

    private GiftCardModel giftCardModel;

    public PurchaseCardFragment() {
        // Required empty public constructor
        giftCardModel = GiftCardModel.getSingleton();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PurchaseCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PurchaseCardFragment newInstance(double pWorth) {
        PurchaseCardFragment fragment = new PurchaseCardFragment();
        Bundle args = new Bundle();
        args.putDouble(PURCHASE_WORTH, pWorth);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            purchaseWorth = getArguments().getDouble(PURCHASE_WORTH, 0);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vf = inflater.inflate(R.layout.fragment_purchase_card, container, false);

        Button purchaseBTN = vf.findViewById(R.id.purchaseBTN);
        purchaseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText purchaseET = (EditText) vf.findViewById(R.id.purchaseET);
                EditText messageET = (EditText) vf.findViewById(R.id.messageET);
                String message = messageET.getText().toString();
                Log.d("Purchase Error", purchaseET.toString());
                try {
                    purchaseWorth = Double.parseDouble(purchaseET.getText().toString());
                } catch (NumberFormatException e) {
                    //purchaseWorth = 100.0;
                    return;
                }
                purchaseET.setText("");
                messageET.setText("");
                giftCardModel.purchaseCard(purchaseWorth, message);
                Toast.makeText(getContext(), "You purchased a card worth " + purchaseWorth + " with code " + (giftCardModel.count()-1), Toast.LENGTH_LONG).show();
                myActivity.update();
            }
        });

        Button toRedeemBTN = vf.findViewById(R.id.toRedeemBTN);
        toRedeemBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myActivity.swapToRedeem();
            }
        });

        return vf;
    }
}
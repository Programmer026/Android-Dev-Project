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
 * Use the {@link PreMadeButtons#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreMadeButtons extends Fragment {

    public interface PreMadeCallBack {
        void update();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters


    private PreMadeButtons.PreMadeCallBack myActivity;

    public void onAttach(Context context) {
        super.onAttach(context);
        myActivity = (PreMadeButtons.PreMadeCallBack) context;
    }

    private GiftCardModel giftCardModel;

    public PreMadeButtons() {
        // Required empty public constructor
        giftCardModel = GiftCardModel.getSingleton();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment PreMadeButtons.
     */
    // TODO: Rename and change types and number of parameters
    public static PreMadeButtons newInstance() {
        PreMadeButtons fragment = new PreMadeButtons();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vf = inflater.inflate(R.layout.fragment_pre_made_buttons, container, false);

        Button fiveBTN = vf.findViewById(R.id.fiveBTN);
        fiveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giftCardModel.purchaseCard(5, "You won $5");
                Toast.makeText(getContext(), "You purchased a card worth 5 with code " + (giftCardModel.count()-1), Toast.LENGTH_LONG).show();
                myActivity.update();
            }
        });

        Button tenBTN = vf.findViewById(R.id.tenBTN);
        tenBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giftCardModel.purchaseCard(10, "You won $10");
                Toast.makeText(getContext(), "You purchased a card worth 10 with code " + (giftCardModel.count()-1), Toast.LENGTH_LONG).show();
                myActivity.update();
            }
        });

        Button twentyfiveBTN = vf.findViewById(R.id.twentyfiveBTN);
        twentyfiveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giftCardModel.purchaseCard(25, "You won $25");
                Toast.makeText(getContext(), "You purchased a card worth 25 with code " + (giftCardModel.count()-1), Toast.LENGTH_LONG).show();
                myActivity.update();
            }
        });

        Button fiftyBTN = vf.findViewById(R.id.fiftyBTN);
        fiftyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giftCardModel.purchaseCard(50, "You won $50");
                Toast.makeText(getContext(), "You purchased a card worth 50 with code " + (giftCardModel.count()-1), Toast.LENGTH_LONG).show();
                myActivity.update();
            }
        });

        return vf;
    }


}
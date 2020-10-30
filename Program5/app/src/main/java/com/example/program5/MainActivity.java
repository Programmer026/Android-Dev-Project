/*Name: Oluwayemisi Runsewe
Class: Mobile Computing Android Development
Assignment: Program 5 - Gift Card Counter
* */
package com.example.program5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PurchaseCardFragment.PurchaseCallBack, RedeemFragment.RedeemCallBack, PreMadeButtons.PreMadeCallBack{

    private GiftCardModel giftCardModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PurchaseCardFragment pFrg = PurchaseCardFragment.newInstance(0);
        RedeemFragment rFrg = RedeemFragment.newInstance(0);
        PreMadeButtons pmb = PreMadeButtons.newInstance();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();

        trans.add(R.id.fragment_container, rFrg, "REDEEM_FRG");
        trans.add(R.id.fragment_container, pFrg, "PURCHASE_FRG");
        trans.add(R.id.button_container,pmb,"PREMADE_BUTTONS");
        trans.hide(rFrg);
        trans.commit();

        //ViewModelProvider.Factory vmf = new ViewModelProvider.NewInstanceFactory();
        //ViewModelProvider vmp = new ViewModelProvider(this, vmf);
        //giftCardModel = vmp.get(GiftCardModel.class);
        giftCardModel = GiftCardModel.getSingleton();


    }

    @Override
    public void swapToPurchase() {
        FragmentManager fm = getSupportFragmentManager();
        RedeemFragment rf = (RedeemFragment) fm.findFragmentByTag("REDEEM_FRG");
        PurchaseCardFragment pf = (PurchaseCardFragment) fm.findFragmentByTag("PURCHASE_FRG");

        FragmentTransaction trans = fm.beginTransaction();
        trans.hide(rf);
        trans.show(pf);
        trans.commit();
    }

    @Override
    public void swapToRedeem() {
        FragmentManager fm = getSupportFragmentManager();
        RedeemFragment rf = (RedeemFragment) fm.findFragmentByTag("REDEEM_FRG");
        PurchaseCardFragment pf = (PurchaseCardFragment) fm.findFragmentByTag("PURCHASE_FRG");

        FragmentTransaction trans = fm.beginTransaction();
        trans.hide(pf);
        trans.show(rf);
        trans.commit();
    }

    @Override
    public void update() {
    TextView purchaseTV = findViewById(R.id.purchaseTV);
    TextView redeemTV = findViewById(R.id.redeemTV);
    purchaseTV.setText(giftCardModel.getNoOfGiftCardsPurchased() + " cards purchased worth " + giftCardModel.getTotalPurchased());
    redeemTV.setText(giftCardModel.getNoOfGiftCardsRedeemed() + " cards redeemed worth " + giftCardModel.getTotalRedeemed());
    }

    public void viewStatus(View v) {
        Intent ini = new Intent(this, Status.class);
        startActivity(ini);
    }


}
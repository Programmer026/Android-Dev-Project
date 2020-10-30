/*Name: Oluwayemisi Runsewe
Class: Mobile Computing Android Development
Assignment: Program 5 - Gift Card Counter
* */
package com.example.program5;

import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class GiftCardModel extends ViewModel {
    private int noOfGiftCardsPurchased;
    private int noOfGiftCardsRedeemed;
    private double totalPurchased;
    private double totalRedeemed;

    public static class Giftcard {
        private double amount;
        private boolean redeemed;
        private String message;

        public Giftcard(double amount, boolean redeemed, String message) {
            this.amount = amount;
            this.redeemed = redeemed;
            this.message = message;
        }

        public void setRedeemed() {
            redeemed = true;
        }

        public double getAmout() {
            return amount;
        }

        public String getMessage() {
            return message;
        }

        public boolean getRedeemed() {
            return redeemed;
        }
    }

    private ArrayList<Giftcard> myCards;

    private GiftCardModel() {
        myCards = new ArrayList<Giftcard>();
    }

    public void purchaseCard(double amount, String message) {
        amount = Math.round(amount * 100.0) / 100.0;
        myCards.add(new Giftcard(amount, false, message));
        totalPurchased += amount;
        noOfGiftCardsPurchased++;
    }

    public Boolean redeemCard(int code) {
        if ((code >= myCards.size()) || (code < 0)) return false;
        if(myCards.get(code).redeemed == true) return false;
        myCards.get(code).setRedeemed();
        noOfGiftCardsRedeemed++;
        totalRedeemed += myCards.get(code).getAmout();
        return true;
    }

    public static GiftCardModel theModel = null;
    public static GiftCardModel getSingleton() {
        if(theModel == null) {
            theModel = new GiftCardModel();
        }
        return theModel;
    }

    public int getNoOfGiftCardsPurchased() {
        return noOfGiftCardsPurchased;
    }

    public int getNoOfGiftCardsRedeemed() {
        return noOfGiftCardsRedeemed;
    }

    public double getTotalPurchased() {
        return totalPurchased;
    }

    public double getTotalRedeemed() {
        return totalRedeemed;
    }

    public int count() {
        return myCards.size();
    }

    public String getTheMessage(int code) {
        return myCards.get(code).getMessage();
    }

    public double getAmount(int code) {
        return myCards.get(code).getAmout();
    }

    public boolean getRedeemedStatus(int code) {
        return myCards.get(code).getRedeemed();
    }


}


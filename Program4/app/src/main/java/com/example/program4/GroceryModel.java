/*Name: Oluwayemisi Runsewe
* Class: Mobile Computing Android
* Project: Program 4
* */
package com.example.program4;

import java.util.ArrayList;

public class GroceryModel {
    //Create GroceryItem class
    public static class GroceryItem {
        public String item;
        public double price;
        public String storeName;
        public int purchaseCount;

        public GroceryItem(String item, double price, String storeName) {
            this.item = item;
            this.price = price;
            this.storeName = storeName;
            purchaseCount = 0;
        }
    }
    //Instance variables
    public ArrayList<GroceryItem> shoppingList;
    public double totalPrice;

    //Initialize the model
    private GroceryModel() {
        shoppingList = new ArrayList<GroceryItem>();
        loadItems();
    }
    //Function to load items into the mode
    private void loadItems() {
        shoppingList.add(new GroceryItem("Dozen Eggs", 2.50, "Walmart"));
        shoppingList.add(new GroceryItem("Pound Sugar", 3.10, "Hyvee"));
        shoppingList.add(new GroceryItem("Tea Cake", 7.35, "Hyvee"));

    }
    //Function to add items to total
    public void addItem(int position) {
        GroceryItem currItem = shoppingList.get(position);
        currItem.purchaseCount += 1;
        totalPrice += currItem.price;
    }


    public int getPurchaseCount(int position) {
        GroceryItem currItem = shoppingList.get(position);
        return currItem.purchaseCount;
    }

    public void clearList() {
        shoppingList = new ArrayList<GroceryItem>();
        loadItems();
        totalPrice = 0.0;
    }

    public void resetTotal() {
        totalPrice = 0.0;
    }

    public static GroceryModel theModel = null;

    public static GroceryModel getSingleton() {
        if(theModel == null) {
            theModel = new GroceryModel();
        }
        return theModel;
    }
}

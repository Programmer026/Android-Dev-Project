/*
* Name : Oluwayemisi Runsewe
* Class : Mobile computing Android
* Project Description : A simple app to that will compute the price of curtains
*                       and track the total cost of the order.
* <a target="_blank" href="https://icons8.com/icons/set/theatre-curtain">Theatre Curtain icon</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a>
* <a target="_blank" href="https://icons8.com/icons/set/clear-symbol">Clear Symbol icon</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a>
* */
package com.example.program3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Initialize private variables
    private static double costPerSquareFoot = 0.25;
    public static String COST_PER_SQUARE = "COST_PER_SQUARE";
    public static String LINE_AMOUNT = "LINE_AMOUNT";
    public static String ORDER_STRING = "ORDER_STRING";
    public static String FIRST_NAME = "FIRST_NAME";
    public static String LAST_NAME = "LAST_NAME";
    public static String ADDRESS = "ADDRESS";
    public static String TAX = "TAX";
    private static String orderDescription = "";
    private static double orderCost = 0.0;
    private static double totalCost = 0;
    private static double total_tax = 0;
    public static  int OTHER_REQ = 1;
    public static int CUST_REQ = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Function to invoke Intent
    public void calculateCost() {
        Button anotherBTN = findViewById(R.id.addMoreBTN);
        Button doneBTN = findViewById(R.id.doneBTN);
        anotherBTN.setVisibility(View.VISIBLE);
        doneBTN.setVisibility(View.VISIBLE);
        Intent myIntent = new Intent(this, CurtainActivity.class);
        myIntent.putExtra(MainActivity.COST_PER_SQUARE, 0.25);
        startActivityForResult(myIntent, OTHER_REQ);
        Log.d("Navigation", "Started Other Activity");
    }

    // Function to get Customer for Order
    public void customerOrder(View v) {
        Intent custIntent = new Intent(this, CustomerActivity.class);
        startActivityForResult(custIntent, CUST_REQ);
    }

    //Function for same customer to make another order
    public void anotherOrder(View v){
        Intent myIntent = new Intent(this, CurtainActivity.class);
        myIntent.putExtra(MainActivity.COST_PER_SQUARE, 0.25);
        startActivityForResult(myIntent, OTHER_REQ);
        Log.d("Navigation", "Started Another Activity");
    }

    //Fuction for Done
    public void doneBTN(View v) {
        Button addCurtainBTN = findViewById(R.id.curtainBTN);
        Button clearBTN = findViewById(R.id.clearBTN);
        Button anotherBTN = findViewById(R.id.addMoreBTN);
        Button doneBTN = findViewById(R.id.doneBTN);
        doneBTN.setVisibility(View.GONE);
        anotherBTN.setVisibility(View.GONE);
        addCurtainBTN.setVisibility(View.VISIBLE);
        clearBTN.setVisibility(View.VISIBLE);
        orderDescription = "";

    }


    //Overide onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if(resultCode == 1){
                   TextView displayOrderTV = findViewById(R.id.displayOrderTV);
                    displayOrderTV.append("Order was canceled.\n");
                }
                String order_line = data.getStringExtra(ORDER_STRING);
                orderDescription += order_line;
                double lineAmount = data.getDoubleExtra(LINE_AMOUNT, 0.0);
                double tax = data.getDoubleExtra(TAX, 0.0);
                orderCost = lineAmount;
                totalCost += orderCost;
                total_tax += tax;
                total_tax = Math.round(total_tax*100.0 )/ 100.0;
                TextView displayOrderTV = findViewById(R.id.displayOrderTV);
                displayOrderTV.setText(orderDescription);
                TextView displayCostTV = findViewById(R.id.displayCostTV);
                displayCostTV.setText("Total before tax: $" + String.valueOf(totalCost) + "\n" +
                        "Tax: $" + String.valueOf(total_tax) + "\n" +
                        "Grand Total: $" + String.valueOf(totalCost + total_tax));
                break;

            case 2:
                String fname = data.getStringExtra(FIRST_NAME);
                String lname = data.getStringExtra(LAST_NAME);
                String adrs = data.getStringExtra(ADDRESS);
                orderDescription += fname + " " + lname + " order to be shipped to " + adrs + " is:\n";
                Button addCurtainBTN = findViewById(R.id.curtainBTN);
                Button clearBTN = findViewById(R.id.clearBTN);
                clearBTN.setVisibility(View.GONE);
                addCurtainBTN.setVisibility(View.GONE);
                calculateCost();
                break;
            default:
                //handle unknown
        }
    }

    //Function to reset order
    public void resetOrder(View v) {
        totalCost = 0;
        total_tax = 0;
        orderCost = 0;
        costPerSquareFoot = 0.25;
        orderDescription = "";
        OTHER_REQ = 1;
        TextView displayOrderTV = findViewById(R.id.displayOrderTV);
        displayOrderTV.setText("");
        TextView displayCostTV = findViewById(R.id.displayCostTV);
        displayCostTV.setText("");

    }

}
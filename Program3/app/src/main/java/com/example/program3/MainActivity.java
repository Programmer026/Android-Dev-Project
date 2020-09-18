/*
* Name : Oluwayemisi Runsewe
* Class : Mobile computing Android
* Project Description : A simple app to that will compute the price of curtains
*                       and track the total cost of the order.
* */
package com.example.program3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Initialize private variables
    private static double costPerSquareFoot = 0.25;
    public static String COST_PER_SQUARE = "COST_PER_SQUARE";
    public static String LINE_AMOUNT = "LINE_AMOUNT";
    public static String ORDER_STRING = "ORDER_STRING";
    private static String orderDescription = "";
    private static double orderCost = 0.0;
    private static double totalCost = 0;
    public static  int OTHER_REQ = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Function to invoke Intent
    public void calculateCost(View v) {
        Intent myIntent = new Intent(this, CurtainActivity.class);
        myIntent.putExtra(MainActivity.COST_PER_SQUARE, 0.25);
        startActivityForResult(myIntent, OTHER_REQ);
        Log.d("Navigation", "Started Other Activity");
    }


    //Overide onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 0:
                String order_line = data.getStringExtra(ORDER_STRING);
                orderDescription += order_line;
                double lineAmount = data.getDoubleExtra(LINE_AMOUNT, 0.0);
                orderCost = lineAmount;
                totalCost += orderCost;
                TextView displayOrderTV = findViewById(R.id.displayOrderTV);
                displayOrderTV.setText(orderDescription);
                TextView displayCostTV = findViewById(R.id.displayCostTV);
                displayCostTV.setText("Total: " + String.valueOf(totalCost));
                break;
            default:
                displayOrderTV = findViewById(R.id.displayOrderTV);
                displayOrderTV.append("Order was canceled.\n");
                break;
        }
    }

    //Function to reset order
    public void resetOrder(View v) {
        totalCost = 0;
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
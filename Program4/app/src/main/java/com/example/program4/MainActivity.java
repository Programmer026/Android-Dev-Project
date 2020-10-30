/*Name: Oluwayemisi Runsewe
 * Class: Mobile Computing Android
 * Project: Program 4
 * */
package com.example.program4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private RecyclerView groceryRV = null;
    private GestureDetectorCompat detector = null;
    private GroceryModel myModel = null;
    private GroceryAdapter myAdapter = null;
    private static DecimalFormat df = new DecimalFormat("0.00");

    //Action to perform when item is clicked on
    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View view = groceryRV.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder holder = groceryRV.getChildViewHolder(view);
                if (holder instanceof GroceryAdapter.GroceryViewHolder) {
                    int position = holder.getAdapterPosition();
                    Log.d("Click", "clicked on item" + position);
                    myModel.addItem(position);
                    TextView totalTV = findViewById(R.id.totalTV);
                    String total = df.format(myModel.totalPrice);
                    totalTV.setText("Total is " + total);
                    return true;
                }
            }
            return false;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myModel = GroceryModel.getSingleton();
        myAdapter = new GroceryAdapter();

        groceryRV = findViewById(R.id.groceryRV);
        groceryRV.setAdapter(myAdapter);
        LinearLayoutManager lin = new LinearLayoutManager(this);
        groceryRV.setLayoutManager(lin);

        detector = new GestureDetectorCompat(this, new RecyclerViewOnGestureListener());
        groceryRV.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return detector.onTouchEvent(e);
            }
        });


        Button addBTN = findViewById(R.id.addBTN);
        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText itemET = findViewById(R.id.itemET);
                String item = itemET.getText().toString();
                EditText priceET =findViewById(R.id.priceET);
                String priceSTR = priceET.getText().toString();
                Double price = Double.parseDouble(priceSTR);
                if (price < 0) {
                    return;
                }
                EditText storeET = findViewById(R.id.storeET);
                String store = storeET.getText().toString();
                myModel.shoppingList.add(new GroceryModel.GroceryItem(item, price, store));
                myAdapter.notifyItemInserted(myAdapter.getItemCount() -1);
                itemET.setText("");
                priceET.setText("");
                storeET.setText("");
            }
        });

        Button clearBTN = findViewById(R.id.clearBTN);
        clearBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myModel.clearList();
                myAdapter.notifyDataSetChanged();
                TextView totalTV = findViewById(R.id.totalTV);
                String total = df.format(myModel.totalPrice);
                totalTV.setText("Total is " + total);
            }
        });

        Button resetBTN = findViewById(R.id.resetBTN);
        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myModel.resetTotal();
                TextView totalTV = findViewById(R.id.totalTV);
                String total = df.format(myModel.totalPrice);
                totalTV.setText("Total is " + total);
            }
        });
    }

    public void instructionIntent(View v) {
        Intent instructionIntent = new Intent(this, Instruction.class);
        startActivity(instructionIntent);
    }
}
/*Name: Oluwayemisi Runsewe
 * Class: Mobile Computing Android
 * Project: Program 4
 * */

package com.example.program4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.math.RoundingMode;
import java.text.DecimalFormat;


import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;


public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {


    public static class GroceryViewHolder extends RecyclerView.ViewHolder {
        public GroceryViewHolder(View v) {
            super(v);
        }
    }

    private GroceryModel theModel;

    public GroceryAdapter() {
        theModel = GroceryModel.getSingleton();
    }

    // Function to tell program what view it is using
    public GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocer_list_view, parent, false);
        GroceryViewHolder vh = new GroceryViewHolder(v);
        return vh;
    }

    //Overriade onBinViewHolder
    public void onBindViewHolder(@NotNull GroceryViewHolder holder, int position) {
        TextView nameTV = holder.itemView.findViewById(R.id.nameTV);
        TextView amountTV = holder.itemView.findViewById(R.id.amountTV);
        TextView storeTV = holder.itemView.findViewById(R.id.storeTV);

        nameTV.setText(theModel.shoppingList.get(position).item);
        amountTV.setText("Price: " + String.valueOf(theModel.shoppingList.get(position).price));
        storeTV.setText("Store: " + theModel.shoppingList.get(position).storeName);
    }

    //Overide getItemCount method
    public int getItemCount() {
        return theModel.shoppingList.size();
    }

}

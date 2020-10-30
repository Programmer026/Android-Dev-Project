package com.example.program5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusViewHolder> {

    public static class StatusViewHolder extends RecyclerView.ViewHolder {
        public StatusViewHolder(View v) {
            super(v);
        }
    }

    private GiftCardModel theModel;
    public StatusAdapter() {
        theModel = GiftCardModel.getSingleton();
    }

    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_list, parent, false);
        StatusViewHolder vh = new StatusViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StatusViewHolder holder, int position) {
        TextView codeTV = holder.itemView.findViewById(R.id.codeTV);
        TextView priceTV = holder.itemView.findViewById(R.id.priceTV);
        TextView noteTV = holder.itemView.findViewById(R.id.noteTV);
        TextView usedTV = holder.itemView.findViewById(R.id.usedTV);

        codeTV.setText("Code: "+position);
        priceTV.setText("Amount: "+theModel.getAmount(position));
        noteTV.setText("Message: " + theModel.getTheMessage(position));
        usedTV.setText("Status: " + theModel.getRedeemedStatus(position));

    }

    @Override
    public int getItemCount() {
        return theModel.count();
    }


}

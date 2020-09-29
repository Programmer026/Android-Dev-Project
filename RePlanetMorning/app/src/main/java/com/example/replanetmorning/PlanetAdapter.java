package com.example.replanetmorning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    public static class PlanetViewHolder extends RecyclerView.ViewHolder {
    // We only have a single chunk of text to display
    // This should match with the root element of the xml we use
    public PlanetViewHolder(View v) {
        super(v);
        }
    }
    private PlanetModel theModel;

    public PlanetAdapter() {

        theModel = PlanetModel.getModel();
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a TextHolder
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planet_list_view, parent, false);
        PlanetViewHolder vh = new PlanetViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        TextView nameTV = holder.itemView.findViewById(R.id.nameTV);
        TextView massTV = holder.itemView.findViewById(R.id.massTV);
        TextView distanceTV = holder.itemView.findViewById(R.id.distanceTV);

        nameTV.setText(theModel.myPlanets.get(position).name);
        massTV.setText("Mass is " + theModel.myPlanets.get(position).mass);
        distanceTV.setText("Distance is " + theModel.myPlanets.get(position).distance);

    }

    @Override
    public int getItemCount() {

        return theModel.myPlanets.size();
    }
}

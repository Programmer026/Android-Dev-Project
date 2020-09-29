package com.example.replanetmorning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private RecyclerView planetRV = null;
        private GestureDetectorCompat detector = null;
        private PlanetModel myModel = null;
        private PlanetAdapter myAdapter = null;

    // We need a gesture listener
    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View view = planetRV.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder holder = planetRV.getChildViewHolder(view);
                if (holder instanceof PlanetAdapter.PlanetViewHolder) {
                    int position = holder.getAdapterPosition();
                    // handle single tap
                    Log.d("click", "clicked on item "+ position);
                    Log.d("click", "name of item was" + myModel.myPlanets.get(position).name);

                    myModel.myPlanets.remove(position);
                    myAdapter.notifyItemRemoved(position);
                    return true; // Use up the tap gesture
                }
            }
            // we didn't handle the gesture so pass it on
            return false;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myModel = PlanetModel.getModel();
        myAdapter = new PlanetAdapter();

        planetRV = findViewById(R.id.planetRV);
        planetRV.setAdapter(myAdapter);
        LinearLayoutManager lin = new LinearLayoutManager(this);
        planetRV.setLayoutManager(lin);

        detector = new GestureDetectorCompat(this,
                new RecyclerViewOnGestureListener());
        // add the listener to the recycler
        planetRV.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return detector.onTouchEvent(e);
                                                          }
        });

        Button addBtn = findViewById(R.id.addBTN);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myModel.myPlanets.add( new PlanetModel.Planet("X", 10.0, 2222.4));
                myAdapter.notifyItemInserted(0);
            }
        });


    }


}
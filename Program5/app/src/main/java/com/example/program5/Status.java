package com.example.program5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Status extends AppCompatActivity {

    private RecyclerView statusRv = null;
    private StatusAdapter myAdapter = null;
    private GiftCardModel myModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        myModel = GiftCardModel.getSingleton();
        myAdapter = new StatusAdapter();

        statusRv = findViewById(R.id.statusRV);
        statusRv.setAdapter(myAdapter);
        LinearLayoutManager lin = new LinearLayoutManager(this);
        statusRv.setLayoutManager(lin);


        Button backBTN = findViewById(R.id.backBTN);
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CustomerActivity extends AppCompatActivity {

    private static String first_name;
    private static String last_name;
    private static String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }

    //Function to get name and address
    public void setInformation(View v) {
        EditText firstNameET = findViewById(R.id.ffirstNameET);
        EditText lastNameET = findViewById(R.id.lastNameET);
        EditText addressET = findViewById(R.id.addressET);
        first_name = firstNameET.getText().toString();
        last_name = lastNameET.getText().toString();
        address = addressET.getText().toString();

        Intent newData = new Intent();
        newData.putExtra(MainActivity.FIRST_NAME, first_name);
        newData.putExtra(MainActivity.LAST_NAME, last_name);
        newData.putExtra(MainActivity.ADDRESS, address);
        setResult(0, newData);
        finish();
    }
}
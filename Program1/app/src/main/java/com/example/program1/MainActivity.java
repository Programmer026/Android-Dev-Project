package com.example.program1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void translateText(View v) {
        EditText fromET = (EditText) findViewById(R.id.translateFromET);
        String fromString = fromET.getText().toString();
        EditText toET = (EditText) findViewById(R.id.translateToET);
        String toString = toET.getText().toString();
        EditText messageET = (EditText) findViewById(R.id.messageET);
        String messageString = messageET.getText().toString();
        String newMessage = messageString.replaceFirst(fromString, toString);
        messageET.setText(newMessage);
    }

    public void translateAllText(View v) {
        EditText fromET = (EditText) findViewById(R.id.translateFromET);
        String fromString = fromET.getText().toString();
        EditText toET = (EditText) findViewById(R.id.translateToET);
        String toString = toET.getText().toString();
        EditText messageET = (EditText) findViewById(R.id.messageET);
        String messageString = messageET.getText().toString();
        String newMessage = messageString.replaceAll(fromString, toString);
        messageET.setText(newMessage);
    }
}
package com.example.program2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//Icons made by <a href="https://www.flaticon.com/authors/flat-icons" title="Flat Icons">Flat Icons</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>
    int num = 6;
    int numOfTopping = 0;
    int olive =0;
    int bacon = 0;
    int cheese = 0;
    int pepperoni = 0;
    int sausage = 0;
    int chicken = 0;
    int jalepeno = 0;
    int lemmonPeppers = 0;
    String orderString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button orderBtn = findViewById(R.id.orderBtn);
        orderBtn.setClickable(false);
    }

    public int getNum() {
        EditText diameterET = (EditText) findViewById(R.id.diameterET);
        String diameter = diameterET.getText().toString();
        num = Integer.parseInt(diameter);
        return num;
    }

    public void checkPizzaDiameter(View v) {
        //if((num < 6) || (num > 20)) return false;
        //return true;
        Button orderBtn = findViewById(R.id.orderBtn);
        TextView messageTV = findViewById(R.id.messageTv);
        if((getNum() < 6) || (getNum() > 20)) {
            messageTV.setText("Invalid Pizza Size");
            orderBtn.setClickable(false);
        }
        else {
            messageTV.setText(" ");
            orderBtn.setClickable(true);
        }

    }

    public void changeOlive(View v){
        Button oliveBtn = findViewById(R.id.oliveBtn);
        if(olive == 0) {
            olive = 1;
            oliveBtn.setText("REMOVE");
        }
        else {
            olive = 0;
            oliveBtn.setText("ADD");
        }
        setOrderString();
    }

    public void changeCheese(View v){
        Button cheeseBtn = findViewById(R.id.cheeseBtn);
        if(cheese == 0) {
            cheese = 1;
            cheeseBtn.setText("REMOVE");
        }
        else {
            cheese = 0;
            cheeseBtn.setText("ADD");
        }
        setOrderString();
    }

    public void changeBacon(View v){
        Button baconBtn = findViewById(R.id.baconBtn);
        if(bacon == 0) {
            bacon = 1;
            baconBtn.setText("REMOVE");
        }
        else {
            bacon = 0;
            baconBtn.setText("ADD");
        }
        setOrderString();
    }

    public void changePepperoni(View v){
        Button pepperoniBtn = findViewById(R.id.pepperoniBtn);
        if(pepperoni == 0) {
            pepperoni = 1;
            pepperoniBtn.setText("REMOVE");
        }
        else {
            pepperoni = 0;
            pepperoniBtn.setText("ADD");
        }
        setOrderString();
    }

    public void changesausage(View v){
        Button sausageBtn = findViewById(R.id.sausageBtn);
        if(sausage == 0) {
            sausage = 1;
            sausageBtn.setText("REMOVE");
        }
        else {
            sausage = 0;
            sausageBtn.setText("ADD");
        }
        setOrderString();
    }

    public void changeChicken(View v){
        Button chickenBtn = findViewById(R.id.chickenBtn);
        if(chicken == 0) {
            chicken = 1;
            chickenBtn.setText("REMOVE");
        }
        else {
            chicken = 0;
            chickenBtn.setText("ADD");
        }
        setOrderString();
    }

    public void changeJalepeno(View v){
        Button jalepenoBtn = findViewById(R.id.jalepenosBtn);
        if(jalepeno == 0) {
            jalepeno = 1;
            jalepenoBtn.setText("REMOVE");
        }
        else {
            jalepeno = 0;
            jalepenoBtn.setText("ADD");
        }
        setOrderString();
    }

    public void changelemonPeppers(View v){
        Button lemonBtn = findViewById(R.id.lemonPeppersiBtn);
        if(lemmonPeppers == 0) {
            lemmonPeppers = 1;
            lemonBtn.setText("REMOVE");
        }
        else {
            lemmonPeppers = 0;
            lemonBtn.setText("ADD");
        }
        setOrderString();
    }

    public void addNumOfTopping(){
        numOfTopping = pepperoni + olive + cheese + bacon + lemmonPeppers + sausage + chicken + jalepeno;
    }

    public double calculateCost(){
        int price = getNum();
        double basicCost = (price * price)/(double)20;
        addNumOfTopping();
        double increaseCost = (((double) numOfTopping / 10) * basicCost) ;    ;
        return basicCost + increaseCost;
    }

    public String allToppings() {
        String strTop = " with toppings: ";
        if (olive == 1) strTop += "Olive ";
        if (cheese == 1) strTop += "Cheese ";
        if (pepperoni == 1) strTop += "Pepperoni ";
        if (bacon == 1) strTop += "Bacon ";
        if (chicken == 1) strTop += "Chicken ";
        if (lemmonPeppers == 1) strTop += "Lemon Peppers ";
        if (sausage == 1) strTop += "Sausage ";
        if (jalepeno == 1) strTop += "Jalepeno ";
        return strTop;
    }

    public void setOrderString() {
        orderString = "Pizza size: " + getNum() + " inches" + allToppings() +"costs: " + (Math.round(calculateCost() * 100.0) / 100.0);
        Log.d("order", orderString);
    }


    public void displayMessage(View v) {
        TextView messageTV = findViewById(R.id.messageTv);
            double cost = calculateCost();
            setOrderString();
            messageTV.setText(orderString);
            Button orderBtn = findViewById(R.id.orderBtn);
            orderBtn.setClickable(false);


    }

    public void reset(View v) {
        EditText diameterET = (EditText) findViewById(R.id.diameterET);
        Button oliveBtn = findViewById(R.id.oliveBtn);
        Button cheeseBtn = findViewById(R.id.cheeseBtn);
        Button baconBtn = findViewById(R.id.baconBtn);
        Button pepperoniBtn = findViewById(R.id.pepperoniBtn);
        Button lemonBtn = findViewById(R.id.lemonPeppersiBtn);
        Button jalepenoBtn = findViewById(R.id.jalepenosBtn);
        Button chickenBtn = findViewById(R.id.chickenBtn);
        Button sausageBtn = findViewById(R.id.sausageBtn);
        Button orderBtn = findViewById(R.id.orderBtn);
        TextView messageTV = findViewById(R.id.messageTv);
        orderBtn.setClickable(false);
        olive = 0;
        oliveBtn.setText("ADD");
        cheese = 0;
        cheeseBtn.setText("ADD");
        bacon = 0;
        baconBtn.setText("ADD");
        pepperoni = 0;
        pepperoniBtn.setText("ADD");
        sausage = 0;
        sausageBtn.setText("ADD");
        chicken = 0;
        chickenBtn.setText("ADD");
        jalepeno = 0;
        jalepenoBtn.setText("ADD");
        lemmonPeppers = 0;
        lemonBtn.setText("ADD");
        messageTV.setText(" ");
        diameterET.setText("6");
        num = 6;
        orderString = "";
    }

}
/*Name: Runsewe Oluwayemisi
* Class: Mobile Development - Android
* Assignment: Program 6 - Use of dialogs
*/
package com.example.program6;

import androidx.annotation.ArrayRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.provider.FontsContractCompat;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.FontRequest;
import android.provider.FontsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ColorDialogFragment.ColorCallBack, SizeDialogFragment.SizeCallBack, LengthDialogFragment.LengthCallBack{
    //Instance variables
    Resources res;
    String[] colorArr;
    String[] sizeArr;
    String[] lengthArr;
    TextView sampleTV;
    String str;

    HandlerThread handlerThread;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defince the pick color button
        Button pickColorBTN = findViewById(R.id.pickColorBTN);
        pickColorBTN.setOnClickListener((view) -> {
            ColorDialogFragment cf = new ColorDialogFragment();
            cf.show(getSupportFragmentManager(), "COLOR");
        });

        //Defince the pick size button
        Button pickSizeBTN = findViewById(R.id.pickSizeBTN);
        pickSizeBTN.setOnClickListener((view -> {
            SizeDialogFragment sf = new SizeDialogFragment();
            sf.show(getSupportFragmentManager(), "SIZE");
        }));

        //Defince the pick length button
        Button pickLengthBTN = findViewById(R.id.lenthBTN);
        pickLengthBTN.setOnClickListener((view -> {
            LengthDialogFragment lf = new LengthDialogFragment();
            lf.show(getSupportFragmentManager(), "LENGTH");
        }));

        sampleTV = findViewById(R.id.sampleTV);
        str = sampleTV.getText().toString();

        res = getResources();
        colorArr = res.getStringArray(R.array.color_menu);
        sizeArr = res.getStringArray(R.array.size_menu);
        lengthArr = res.getStringArray(R.array.length_menu);

        handlerThread = new HandlerThread("Font Thread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }

    /**
     * Sets the color of the text according to the option chosen by the user
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void pickColor(int i) {
        //TextView sampleTV = findViewById(R.id.sampleTV);
        TextView colorTV = findViewById(R.id.colorTV);
        String chosen_color = colorArr[i];
        colorTV.setText("Color Chosen: " + chosen_color);
        int col;
        try{
            col = Color.parseColor(chosen_color);
        } catch (Exception e) {
            col = Color.BLACK;
        }
        sampleTV.setTextColor(col);
    }

    /**
     * Sets the size of the font according to the option chosen by the user
     */
    public void pickSize(int i) {
        //TextView sampleTV = findViewById(R.id.sampleTV);
        TextView sizeTV = findViewById(R.id.sizeTV);
        float size = Integer.parseInt(sizeArr[i]);
        sizeTV.setText("Size Chosen: " + size + "dp");
        sampleTV.setTextSize(size);
    }

    /**
     * Get the length from the Length array and sets the text to that length
     * the length in the place means the number of times the sample text shows on the scree
     */

    @Override
    public void pickLength(int i) {
        StringBuilder builder = new StringBuilder();
        builder.append(str + "\n");
        String chosen_length = lengthArr[i];
        Random random = new Random();
        if(chosen_length.equals("medium")){
            int rand = random.nextInt(10) + 1;
            for(int j = 0; j < rand; j++) {
                builder.append(str + "\n");
            }
        }
        else if(chosen_length.equals("long")){
            int rand = random.nextInt(20) + 10;
            for(int j = 0; j < rand; j++) {
                builder.append(str + "\n");
            }
        }
        sampleTV.setText(builder.toString());

    }

    /**
     * I was trying to change the font but for some reason it isnt working. Hope to work on it later.
     */

    /*
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void pickFont() {
        FontRequest request = new FontRequest("com.google.android.gms.font",
                "com.google.android.gms",
                "arizonia",
                R.array.com_google_android_gms_fonts_certs);
        FontsContractCompat.FontRequestCallback callback = new FontsContractCompat.FontRequestCallback() {
            @Override
            public void onTypefaceRetrieved(Typeface typeface) {
                sampleTV.setTypeface(typeface);
            }

            @Override
            public void onTypefaceRequestFailed(int reason) {

            }
        };

        FontsContractCompat.requestFont(this, request, callback, handler);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
    }*/
}
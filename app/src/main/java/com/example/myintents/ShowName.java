package com.example.myintents;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class ShowName extends AppCompatActivity {

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);

        output = findViewById(R.id.output);


        //set app to fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#900C3F"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("name");
            if(!value.isEmpty())
            output.setText(output.getText().toString()+" "+value);
            else
            output.setText("Nothing Was Passed!");

        }

    }
}
package com.example.myintents;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    Button longtext;
    Button addevent;
    Button showname;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date currentTime = Calendar.getInstance().getTime();

        longtext = findViewById(R.id.longtext);
        addevent = findViewById(R.id.addevent);
        showname = findViewById(R.id.shownametv);
        name = findViewById(R.id.nametv);

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



        //go to the long text page
        longtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent k = new Intent(MainActivity.this, LongText.class);
                    startActivity(k);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
        });


        //go to another activity taking some parameters
        showname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ShowName.class);
                i.putExtra("name", name.getText().toString());
                startActivity(i);
            }
        });



        //launch the add event intent
        addevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, currentTime);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, currentTime);
                intent.putExtra(CalendarContract.Events.ALL_DAY, false);
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Descripttion");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
                startActivity(Intent.createChooser(intent, "Add to calendar"));

            }
        });
    }
}
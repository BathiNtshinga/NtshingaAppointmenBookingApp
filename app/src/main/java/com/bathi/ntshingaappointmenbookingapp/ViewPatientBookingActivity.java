package com.bathi.ntshingaappointmenbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewPatientBookingActivity extends AppCompatActivity {

    static myDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient_booking);
        final LinearLayout ll=(LinearLayout)findViewById(R.id.viewpatientbookingactivity);


        LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor c = ViewPatientBookingActivity.myDB.getAllPatientsBooking();
        c.moveToFirst();

        if (c == null) {
            Toast.makeText(getApplicationContext(),"Error!! Cursor is null",Toast.LENGTH_LONG).show();
        }else {
            //Adding Columns for folder number, patient name and Booking Date


            //Creating for five Patients

            while (c.moveToNext()) {
                String fnr = c.getString(0);
                String pname = c.getString(1);
                String pbooking= c.getString(2);
                LinearLayout myLayout = new LinearLayout(this);
                myLayout.setOrientation(LinearLayout.HORIZONTAL);

                //Creating a text view on search
                TextView fnumber = new TextView(this);
                fnumber.setText(fnr+ "  ");
                fnumber.setWidth(150);
                myLayout.addView(fnumber);

                TextView patname = new TextView(this);
                patname.setText("  "+ pname+"  ");
                patname.setWidth(500);
                myLayout.addView(patname);


                final TextView booking = new TextView(this);
                booking.setWidth(140);
                booking.setText("  "+ pbooking);
                booking.setLayoutParams(params);

                final String fnr1 = fnr;
                booking.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Log.i("TAG", "index:" + fnr1);
                        Toast.makeText(getApplicationContext(), "Clicked Count Index:" + fnr1, Toast.LENGTH_LONG).show();
                    }
                });
                myLayout.addView(booking);
                ll.addView(myLayout);
            }
        }
    }
}
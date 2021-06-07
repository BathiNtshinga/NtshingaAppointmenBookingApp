package com.bathi.ntshingaappointmenbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DeletePatientBookingActivity extends AppCompatActivity {

    static myDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_patient_booking);
        LinearLayout myLayout=(LinearLayout)findViewById(R.id.deletepatientbookingactivity);
        myDB = new myDatabase(this);

        LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor c = DeletePatientBookingActivity.myDB.getAllPatientsBooking();
        c.moveToFirst();

        if (c == null) {
            Toast.makeText(getApplicationContext(),"Error!! Cursor is null",Toast.LENGTH_LONG).show();
        }else{


        while (c.moveToNext()){
            String fnr = c.getString(0);
            String pname = c.getString(1);
            String pbooking= c.getString(2);

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView fnumber = new TextView(this);
            fnumber.setText(fnr+ "  ");
            fnumber.setWidth(150);
            ll.addView(fnumber);

            TextView patname = new TextView(this);
            patname.setText("  "+ pname);
            patname.setWidth(500);
            ll.addView(patname);

            TextView booking = new TextView(this);
            booking.setWidth(140);
            booking.setText(pbooking);
            ll.addView(booking);

            final String index = (String) fnr;
            int x=1;
            if(fnr==null||fnr.equals("")||fnr.equals("")) {
                fnr = "0" + x;
                x++;
            }
            final Button btn = new Button(this);
            btn.setId(Integer.parseInt((String)index));
            btn.setText("Delete");
            btn.setLayoutParams(params);

            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.i("TAG", "index:" + index);
                    boolean res = DeletePatientBookingActivity.myDB.removePatient(Integer.parseInt(index));
                    if (res)
                    Toast.makeText(getApplicationContext(), "Patient Booking Deleted" + index,
                            Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Student Deletion Failed!!!:" + index,
                                Toast.LENGTH_LONG).show();
                }
                });
            ll.addView(btn);
            myLayout.addView(ll);
        }
        }
    }
}
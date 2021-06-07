package com.bathi.ntshingaappointmenbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePatientActivity extends AppCompatActivity {

    Button clear;
    EditText foldernr;
    EditText patname;
    EditText booking;
    static myDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_patient);
        clear=(Button) findViewById(R.id.clearFields);
        foldernr=(EditText)findViewById(R.id.foldernr);
        patname=(EditText)findViewById(R.id.patname);
        booking=(EditText)findViewById(R.id.booking);
        myDB=new myDatabase(this);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foldernr.setText("");
                patname.setText("");
                booking.setText("");
            }
        });
    }

    public void saveBooking (View v){
        String fnumber=foldernr.getText().toString();
        String pname=patname.getText().toString();
        String bid=booking.getText().toString();

        //Validation rule if fields are empty
        if(bid.equals("")||patname.equals("")|| fnumber.endsWith("")){
          Toast.makeText(getApplicationContext(), "All records are mandatory...", Toast.LENGTH_LONG).show();
        }else {
            boolean re = CreatePatientActivity.myDB.insertPatient(fnumber, pname, bid);

            if (re)
                Toast.makeText(CreatePatientActivity.this, "Booked Successfully :" + bid, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(CreatePatientActivity.this, "Patient Booking Failed :" + bid, Toast.LENGTH_LONG).show();
        }
        foldernr.setText("");
        patname.setText("");
        booking.setText("");
    }
}
package com.bathi.ntshingaappointmenbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PatientsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);
    }

    public void cPatient(View v){
        Intent i = new Intent(PatientsActivity.this, CreatePatientActivity.class);
        startActivity(i);
    }

    public void callViewPatientBooking(View v){
        Intent i = new Intent(PatientsActivity.this, ViewPatientBookingActivity.class);
        startActivity(i);

    }
}
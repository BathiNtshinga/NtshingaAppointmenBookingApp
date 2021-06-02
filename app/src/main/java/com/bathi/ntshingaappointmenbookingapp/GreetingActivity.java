package com.bathi.ntshingaappointmenbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    TextView name123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        name123=(TextView)findViewById(R.id.name123);
        Bundle b = getIntent().getExtras();
        String name=b.getString("name");
        name123.setText("Mr/Ms. "+name);
    }
}
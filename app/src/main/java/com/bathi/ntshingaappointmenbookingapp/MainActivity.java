package com.bathi.ntshingaappointmenbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText name;
EditText pass;
static myDatabase myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name =(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);
        myDB=new myDatabase(this);
    }

    //login logic for receptionist
    public void loginCheck(View v){



    }

    public void register (View v){
        Intent i = new Intent(MainActivity.this,RegistrationActivity.class);
        startActivity(i);

    }
}
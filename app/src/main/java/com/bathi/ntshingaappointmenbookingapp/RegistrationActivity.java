package com.bathi.ntshingaappointmenbookingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5;
    static myDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.age);
        ed3=(EditText)findViewById(R.id.salary);
        ed4=(EditText)findViewById(R.id.email);
        ed5=(EditText)findViewById(R.id.password1);
    }

    //Business Logic for calling insertData of myDatabase class
    public void saveInfo(View v){
        String name= ed1.getText().toString().trim();
        int age =Integer.parseInt(ed2.getText().toString().trim());
        float salary = Float.parseFloat(ed3.getText().toString().trim());
        String email=ed4.getText().toString().trim();
        String pass= ed5.getText().toString().trim();
        if(name.equals("")||age<1||salary<1|| email.equals("")||pass.equals(""))
        {
            Toast.makeText(getApplicationContext(), "All Entries are Mandatory...",Toast.LENGTH_LONG).show();

        }else {

            boolean result = MainActivity.myDB.insertData(name, age, salary, email, pass);

            if (result) {
                Toast.makeText(RegistrationActivity.this, name + " Registered Successfully", Toast.LENGTH_LONG).show();
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
            } else {
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setMessage("Username Already Exists");
                ad.show();
            }
            ed5.setText("");
        }
    }

    public void goBack(View v){
        Intent i = new Intent(RegistrationActivity.this,MainActivity.class);
        startActivity(i);
    }
}
package com.bathi.ntshingaappointmenbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

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
        String email=name.getText().toString().trim();
        String pass1=pass.getText().toString().trim();

        //Validating Input Entries
        if(email.equals("")|| pass1.equals("'")){
            Toast.makeText(getApplicationContext(),"All Entries are Compulsory...", Toast.LENGTH_LONG).show();

        }else {

            Cursor c = MainActivity.myDB.recLoginCheck(email);
            c.moveToFirst();
            if (c == null) {
                Toast.makeText(MainActivity.this, "Incorrect Details for" + email, Toast.LENGTH_LONG).show();
                name.setText("");
                pass.setText("");
            } else {
                String name2 = c.getString(0);
                String pass2 = c.getString(1);
                if (pass1.equals(pass2)) {
                    Intent i = new Intent(MainActivity.this, GreetingActivity.class);
                    i.putExtra("name", name2);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect Credentials for User" + email, Toast.LENGTH_LONG).show();
                }
                name.setText("");
                pass.setText("");
            }
        }
    }
//login for Receptionist Registration
    public void register (View v){
        Intent i = new Intent(MainActivity.this,RegistrationActivity.class);
        startActivity(i);
    }
}
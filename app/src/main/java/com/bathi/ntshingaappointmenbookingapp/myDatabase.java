package com.bathi.ntshingaappointmenbookingapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class myDatabase extends SQLiteOpenHelper {

    Context c;
    public static String DBNAME="NTSHINGAAPP";
    public static int VERSION=2;
    public myDatabase(Context context){
        super(context, DBNAME, null, VERSION);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            //Receptionist Table
            String query = "CREATE TABLE RECEPTIONISTdata (Name TEXT,Age INTEGER, Salary REAL, Email TEXT PRIMARY KEY, Password TEXT)";
            db.execSQL(query);

            //Patients Table
            String pquery = " CREATE TABLE PatientsBooking (foldenr TEXT,name TEXT, booking TEXT)";
            db.execSQL(pquery);

            Toast.makeText(c,"Table Created Successfully", Toast.LENGTH_LONG).show();
            Toast.makeText(c,"Table Created Successfully", Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            Log.e("MYDATABASE", "Table Error",e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

   // Inserting Records into the database table
    public boolean insertData(String name, int age, float salary, String email, String pass){

        try {
            String query="insert into RECEPTIONISTdata values('"+name+"',"+age+", "+salary+", '"+email+"', '"+pass+"')";
            SQLiteDatabase db=getWritableDatabase();
            db.execSQL(query);
            Toast.makeText(c,name+" Registration Success", Toast.LENGTH_LONG).show();
            return true;

        } catch(Exception e) {
            Log.e("MYDATABASE", "Record Insertion have failed", e);
            return false;
        }
    }
    public Cursor recLoginCheck(String email){
        try{
            String query = "Select Name, Password from RECEPTIONISTdata where Email='"+email+"''";
            SQLiteDatabase db=getWritableDatabase();
            Cursor c=db.rawQuery(query, null);
            return c;


        } catch(Exception e) {
            Log.e("myDataBase", "Login Failure", e);
            return null;

        }

    }

    public boolean insertPatient(String foldernr, String patname, String booking ){

        try {
            String query="insert into PatientsBooking values('"+foldernr+"',"+patname+", "+booking+",)";
            SQLiteDatabase db=getWritableDatabase();
            db.execSQL(query);
            Toast.makeText(c,patname+" Booking Saved Successfully", Toast.LENGTH_LONG).show();
            return true;

        } catch(Exception e) {
            Log.e("MYDATABASE", "Booking Creation failed", e);
            return false;
        }
    }

    //Getting all patient Bookings
    public Cursor getAllPatientsBooking() {
        try {
            String query = "Select foldenr,name, booking from PatientsBooking";
            SQLiteDatabase db = getWritableDatabase();
            Cursor c = db.rawQuery(query, null);
            return c;


        } catch (Exception e) {
            Log.e("myDataBase", "getAllPatients Methods", e);
            return null;
        }
    }
}

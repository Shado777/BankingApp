package com.example.sisonkebank;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BankUser extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SisonkeBank";
    public static final String TABLE_NAME = "Users";


    public static final String COL1= "cEmail";
    public static final String COL2 = "cName";
    public static final String COL3 = "cSurname";
    public static final String COL4 = "cMobile";
    public static final String COL5 = "cGender";
    public static final String COL6 = "Current_Account";
    public static final String COL7 = "Savings_Account";
    public static final String COL8 = "cPassword";


    public BankUser(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query1 = "CREATE TABLE "+TABLE_NAME+"(Email VARCHAR(100) PRIMARY KEY,cName VARCHAR(50),cSurname VARCHAR(50),cMobile VARCHAR(12),cGender VARCHAR(20),Current_Account double,Savings_Account double,cPassword VARCHAR(50))";
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean addUser(String cEmail_I, String cName_I, String cSurname_I, String cMobile_I, String cGender_I, double curAcc_I, double saveAcc_I, String cPasw_I) {
        /*
        String insertQuery = "INSERT INTO users (cEmail,cName,cSurname,cMobile,cGender,curAcc,saveAcc,cPasw)" +
                "VALUES('"+cEmail+"','"+cName+"','"+cSurname+"','"+cMobile+"','"+cGender+"','"+curAcc+"','"+saveAcc+"','"+cPasw+"');";
        */
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentVal = new ContentValues();
        contentVal.put(COL1,cEmail_I);
        contentVal.put(COL2,cName_I);
        contentVal.put(COL3,cSurname_I);
        contentVal.put(COL4,cMobile_I);
        contentVal.put(COL5,cGender_I);
        contentVal.put(COL6,curAcc_I);
        contentVal.put(COL7,saveAcc_I);
        contentVal.put(COL8,cPasw_I);
        long result = db.insert(TABLE_NAME,null,contentVal);
        if(result == -1){
            return true;
        }
        else {
            return false;
        }

    }
}

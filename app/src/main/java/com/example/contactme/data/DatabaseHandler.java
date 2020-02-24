package com.example.contactme.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.contactme.util.Util;

//should extend SQLiteOpenHelper

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    //Creating our database

    /**
     * create table table_name(id Integer primary key, name Text, phone_number Text}
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE="CREATE TABLE "+ Util.TABLE_NAME + "("
                +Util.KEY_ID + " INTEGER PRIMARY KEY,"+ Util.KEY_NAME + " TEXT,"
                + Util.KEY_PHONE_NUMBER+" TEXT" +")";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

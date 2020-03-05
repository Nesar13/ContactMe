package com.example.contactme.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.contactme.R;
import com.example.contactme.model.Contact;
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
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NAME + " TEXT,"
                + Util.KEY_PHONE_NUMBER + " TEXT" + ")";

        //Creating table
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //DROP TABLE IF EXISTS
        String DROP_TABLE = String.valueOf(R.string.db_drop);
        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});

        //Create database again
        onCreate(db);


    }


    /**
     * CRUD= Create, Read, Update, and Delete
     *
     * @param contact passed so we can access the Contact Java class to put values
     */
    public void addContact(Contact contact) {
        SQLiteDatabase db = getReadableDatabase();


        //ContentValues is recommended to use when you use a database, similar to hashmap but has other features
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());

        db.insert(Util.TABLE_NAME, null, values);

                db.close();


    }

    public Contact getContact(int id) {
        SQLiteDatabase db=this.getReadableDatabase();

        //Cursor allows users to get query through our table
        //
        Cursor cursor=db.query(Util.TABLE_NAME, new String[]{ Util.KEY_ID, Util.KEY_NAME, Util.KEY_PHONE_NUMBER},
                Util.KEY_ID + "=?", new String[] {String.valueOf(id)}, null, null, null );

        if (null != cursor) {
            cursor.moveToFirst();
        }


        return null;
    }
}

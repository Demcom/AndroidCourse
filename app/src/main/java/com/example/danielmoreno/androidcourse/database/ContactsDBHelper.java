package com.example.danielmoreno.androidcourse.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.danielmoreno.androidcourse.models.Contact;

import java.util.ArrayList;

public class ContactsDBHelper {

    private static final String DB_NAME = "Contacts";
    private static final String USER_TABLE_NAME = "Users";
    private static final String FIRST_NAME_FIELD = "firstName";
    private static final String LAST_NAME_FIELD = "lastName";
    private static final String PHONE_NUMBER_FIELD = "phoneNumber";
    private static final String IMAGE_ID_FIELD = "imageId";

    private Context mContext;
    private SQLiteDatabase mSqlLiteDatabase;

    public ContactsDBHelper(Context context) {
        this.mContext = context;
        mSqlLiteDatabase = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        mSqlLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "
                + USER_TABLE_NAME
                + String.format(" (%s VARCHAR, %s VARCHAR, %s VARCHAR, %s VARCHAR);", FIRST_NAME_FIELD, LAST_NAME_FIELD, PHONE_NUMBER_FIELD, IMAGE_ID_FIELD));
    }

    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        String[] columns = { FIRST_NAME_FIELD, LAST_NAME_FIELD, PHONE_NUMBER_FIELD, IMAGE_ID_FIELD };
        Cursor cursor = mSqlLiteDatabase.query(USER_TABLE_NAME, columns, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Contact contact = new Contact();
            contact.setFirstName(cursor.getString(cursor.getColumnIndex(FIRST_NAME_FIELD)));
            contact.setLastName(cursor.getString(cursor.getColumnIndex(LAST_NAME_FIELD)));
            contact.setPhoneNumber(cursor.getString(cursor.getColumnIndex(PHONE_NUMBER_FIELD)));
            contact.setImageId(cursor.getString(cursor.getColumnIndex(IMAGE_ID_FIELD)));
            contacts.add(contact);
        }
        cursor.close();
        return contacts;
    }

    public void insertContact(Contact contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME_FIELD, contact.getFirstName());
        contentValues.put(LAST_NAME_FIELD, contact.getLastName());
        contentValues.put(PHONE_NUMBER_FIELD, contact.getPhoneNumber());
        contentValues.put(IMAGE_ID_FIELD, contact.getImageId());
        mSqlLiteDatabase.insert(USER_TABLE_NAME, null, contentValues);
    }



}

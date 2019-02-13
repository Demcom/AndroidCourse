package com.example.danielmoreno.androidcourse.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class ContactsDBHelper {
    private static final String DB_NAME = "Contacts";
    private static final String USER_TABLE_NAME = "Users";

    private static final String ID_FIELD = "id";
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

    public boolean insertUser(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME_FIELD, user.getFirstName());
        contentValues.put(LAST_NAME_FIELD, user.getLastName());
        contentValues.put(PHONE_NUMBER_FIELD, user.getPhoneNumber());
        contentValues.put(IMAGE_ID_FIELD, user.getImageId());
        try {
            mSqlLiteDatabase.insert(USER_TABLE_NAME, null, contentValues);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> userArrayList = new ArrayList<>();
        try {
            String[] projection = {
                    FIRST_NAME_FIELD,
                    FIRST_NAME_FIELD,
                    LAST_NAME_FIELD,
                    PHONE_NUMBER_FIELD,
                    IMAGE_ID_FIELD
            };
            Cursor cursor = mSqlLiteDatabase.query(USER_TABLE_NAME, projection, null, null, null, null, null);
        User user = new User();
            while (cursor.moveToNext()) {
                user.setFirstName(cursor.getString(cursor.getColumnIndex(FIRST_NAME_FIELD)));
                user.setLastName(cursor.getString(cursor.getColumnIndex(LAST_NAME_FIELD)));
                user.setPhoneNumber(cursor.getString(cursor.getColumnIndex(PHONE_NUMBER_FIELD)));
                user.setImageId(cursor.getString(cursor.getColumnIndex(IMAGE_ID_FIELD)));
                userArrayList.add(user);
            }
            cursor.close();
        } catch (Exception e) {
            Log.e(e.getMessage(), "");
        }
        return userArrayList;
    }



}

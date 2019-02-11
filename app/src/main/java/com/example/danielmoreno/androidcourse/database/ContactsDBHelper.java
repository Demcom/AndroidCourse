package com.example.danielmoreno.androidcourse.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ContactsDBHelper {
    private static final String USER_TABLE_NAME = "Users";
    private static final String FIRST_NAME_FIELD = "firstName";
    private static final String LAST_NAME_FIELD = "lastName";
    private static final String PHONE_NUMBER_FIELD = "phoneNumber";
    private static final String IMAGE_ID_FIELD = "imageId";

    Context mContext;
    SQLiteDatabase mSqlLiteDatabase;

    public ContactsDBHelper(Context context) {
        mContext = context;
        mContext.openOrCreateDatabase("Contacts", Context.MODE_PRIVATE, null);
        mSqlLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "
                + USER_TABLE_NAME
                + String.format(" (%s VARCHAR, %s VARCHAR, %s VARCHAR, %s VARCHAR);", FIRST_NAME_FIELD, LAST_NAME_FIELD, PHONE_NUMBER_FIELD, IMAGE_ID_FIELD));
    }


}

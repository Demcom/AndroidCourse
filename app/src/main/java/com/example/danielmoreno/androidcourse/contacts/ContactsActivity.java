package com.example.danielmoreno.androidcourse.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.danielmoreno.androidcourse.R;
import com.example.danielmoreno.androidcourse.contacts.fragments.ContactsFragment;
import com.example.danielmoreno.androidcourse.database.ContactsDBHelper;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ContactsDBHelper contactsDBHelper = new ContactsDBHelper(this);
        getSupportActionBar().setTitle("Contacts");

    }

}

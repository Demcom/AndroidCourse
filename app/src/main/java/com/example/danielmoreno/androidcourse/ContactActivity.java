package com.example.danielmoreno.androidcourse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.danielmoreno.androidcourse.fragments.ContactListFragment;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showFloatingButtonForContact();
    }

    public void showFloatingButtonForContact() {
        if (getSupportFragmentManager() != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
            if (fragment instanceof ContactListFragment) {
                ContactListFragment contactListFragment = (ContactListFragment) fragment;
                contactListFragment.showFloatingActionButton(true);
                contactListFragment.updateData();
            }
        }
    }
}
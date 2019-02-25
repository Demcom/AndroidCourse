package com.example.danielmoreno.androidcourse.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danielmoreno.androidcourse.R;
import com.example.danielmoreno.androidcourse.database.ContactsDBHelper;
import com.example.danielmoreno.androidcourse.models.Contact;


public class ContactFormFragment extends Fragment {
    private EditText mFirstNameEditText, mLastNameEditText, mPhoneNumberEditText;
    private Button mSaveButton;

    public ContactFormFragment() { }

    public static ContactFormFragment newInstance() {
        ContactFormFragment fragment = new ContactFormFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_form, container, false);
        mFirstNameEditText = view.findViewById(R.id.firstNameEditText);
        mLastNameEditText = view.findViewById(R.id.lastNameEditText);
        mPhoneNumberEditText = view.findViewById(R.id.phoneEditText);
        mSaveButton = view.findViewById(R.id.saveButton);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = mFirstNameEditText.getText().toString();
                String lastName = mLastNameEditText.getText().toString();
                String phoneNumber = mPhoneNumberEditText.getText().toString();
                String imageId = "";
                Contact contact = new Contact(firstName, lastName, phoneNumber, imageId);
                saveToDataBase(contact);
            }
        });

        return view;
    }

    public void saveToDataBase(Contact contact) {
        ContactsDBHelper contactsDBHelper = new ContactsDBHelper(getContext());
        contactsDBHelper.insertContact(contact);
        Toast.makeText(getContext(), "Contact saved", Toast.LENGTH_LONG).show();
    }

}

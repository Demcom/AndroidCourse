package com.example.danielmoreno.androidcourse.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.danielmoreno.androidcourse.R;
import com.example.danielmoreno.androidcourse.adapters.ContactListAdapter;
import com.example.danielmoreno.androidcourse.database.ContactsDBHelper;
import com.example.danielmoreno.androidcourse.models.Contact;

import java.util.ArrayList;

public class ContactListFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton mAddActionButton;
    private RecyclerView mContactsRecyclerView;
    private ContactListAdapter mContactListAdapter;
    private ContactsDBHelper mDbHelper;

    public ContactListFragment() {
        // Required empty public constructor
    }

    public static ContactListFragment newInstance() {
        ContactListFragment fragment = new ContactListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        mAddActionButton = view.findViewById(R.id.addButton);
        mAddActionButton.setOnClickListener(this);
        mContactsRecyclerView = view.findViewById(R.id.contactRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        mContactsRecyclerView.setLayoutManager(linearLayoutManager);

        mDbHelper = new ContactsDBHelper(getContext());

        ArrayList<Contact> contacts = mDbHelper.getAllContacts();

        if( contacts != null){
            mContactListAdapter = new ContactListAdapter(contacts, getContext());

            mContactsRecyclerView.setAdapter(mContactListAdapter);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addButton) {
            ContactFormFragment contactFormFragment = ContactFormFragment.newInstance();
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, contactFormFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            showFloatingActionButton(false);
        }
    }

    public void showFloatingActionButton(boolean show) {
        if (show) {
            mAddActionButton.show();
            return;
        }
        mAddActionButton.hide();
    }

    public void updateData() {
        mContactListAdapter.setContactArrayList(mDbHelper.getAllContacts());
        mContactListAdapter.notifyDataSetChanged();
    }
}

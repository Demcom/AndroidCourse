package com.example.danielmoreno.androidcourse.contacts.fragments;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danielmoreno.androidcourse.R;
import com.example.danielmoreno.androidcourse.contacts.ContactsAdapter;
import com.example.danielmoreno.androidcourse.database.ContactsDBHelper;
import com.example.danielmoreno.androidcourse.database.User;

import java.util.ArrayList;

public class ContactsFragment extends Fragment implements View.OnClickListener {
    private RecyclerView mContactsRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private TextView emptyTextView;
    private FloatingActionButton floatingAddActionButton;


    public ContactsFragment() {

    }

    public static ContactsFragment newInstance() {
        ContactsFragment fragment = new ContactsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        if (view != null) {
            floatingAddActionButton = view.findViewById(R.id.addContactButton);
            floatingAddActionButton.setOnClickListener(this);
            emptyTextView = view.findViewById(R.id.emptyTextView);
            mContactsRecyclerView = view.findViewById(R.id.contactsRecyclerView);
            mLinearLayoutManager = new LinearLayoutManager(getContext());
            mContactsRecyclerView.setHasFixedSize(true);
            mContactsRecyclerView.setLayoutManager(mLinearLayoutManager);
            ContactsDBHelper contactsDBHelper = new ContactsDBHelper(getContext());
            ArrayList<User> userArrayList = contactsDBHelper.getUsers();
            if (userArrayList.size() == 0) {
                emptyTextView.setVisibility(View.VISIBLE);
            }
            ContactsAdapter contactsAdapter = new ContactsAdapter(getContext(), userArrayList);
            mContactsRecyclerView.setAdapter(contactsAdapter);
            contactsAdapter.notifyDataSetChanged();
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addContactButton) {
            ContactForm newFragment = new ContactForm();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_left, R.anim.exit_to_right, R.anim.exit_to_right, R.anim.exit_to_right);
            ft.replace(R.id.contacts_fragment_container, newFragment);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}

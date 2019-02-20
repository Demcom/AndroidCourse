package com.example.danielmoreno.androidcourse.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.danielmoreno.androidcourse.R;

public class ContactListFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton mAddActionButton;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        mAddActionButton = view.findViewById(R.id.addButton);
        mAddActionButton.setOnClickListener(this);
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
            mAddActionButton.hide();
        }
    }

    public void showFAB(boolean show) {
        if (show) {
            mAddActionButton.show();
            return;
        }
        mAddActionButton.hide();
    }
}

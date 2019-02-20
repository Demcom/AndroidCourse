package com.example.danielmoreno.androidcourse.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danielmoreno.androidcourse.R;


public class ContactFormFragment extends Fragment {

    public ContactFormFragment() {
        // Required empty public constructor
    }

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_form, container, false);
    }

}

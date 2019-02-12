package com.example.danielmoreno.androidcourse.contacts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danielmoreno.androidcourse.R;

public class ContactForm extends Fragment {

    public ContactForm() {
        // Required empty public constructor
    }

    public static ContactForm newInstance(String param1, String param2) {
        ContactForm fragment = new ContactForm();
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

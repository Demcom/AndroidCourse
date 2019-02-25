package com.example.danielmoreno.androidcourse.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielmoreno.androidcourse.R;
import com.example.danielmoreno.androidcourse.models.Contact;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter< ContactViewHolder > {

    private ArrayList<Contact> mContactArrayList;
    private Context mContext;

    public ContactListAdapter(ArrayList<Contact> contactArrayList, Context context){
        mContactArrayList = contactArrayList;
        mContext = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View contactsView = LayoutInflater.from(mContext).inflate(R.layout.contact_item, viewGroup, false);
        ContactViewHolder contactsViewHolder = new ContactViewHolder(contactsView);
        return contactsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        Contact contact = mContactArrayList.get(i);
        contactViewHolder.setFullName(contact.getFirstName(), contact.getLastName());
        contactViewHolder.setmPhoneNumber(contact.getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return mContactArrayList.size();
    }

    public void setContactArrayList(ArrayList<Contact> contactArrayList){
        mContactArrayList = contactArrayList;
    }
}

class ContactViewHolder extends RecyclerView.ViewHolder{
    private TextView mFullName, mPhoneNumber;
    private ImageView mContactImageView;

    public ContactViewHolder(View itemView){
        super(itemView);

        mFullName = itemView.findViewById(R.id.name_textView);
        mPhoneNumber = itemView.findViewById(R.id.phone_textView);
        mContactImageView = itemView.findViewById(R.id.contact_ImageView);
    }

    public void setFullName(String firstName, String lastName){
        String fullName = firstName + " " + lastName;
        mFullName.setText(fullName);
    }

    public void setmPhoneNumber(String phoneNumber){
        mPhoneNumber.setText(phoneNumber);
    }
}

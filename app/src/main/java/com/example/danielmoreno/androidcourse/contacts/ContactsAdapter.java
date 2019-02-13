package com.example.danielmoreno.androidcourse.contacts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielmoreno.androidcourse.R;
import com.example.danielmoreno.androidcourse.database.User;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    private ArrayList<User> userArrayList;
    private Context mContext;

    public ContactsAdapter(Context context, ArrayList<User> userArrayList) {
        mContext = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View contactsView = LayoutInflater.from(mContext).inflate(R.layout.contacts_viewholder, viewGroup, false);
        ContactsViewHolder contactsViewHolder = new ContactsViewHolder(contactsView);
        return contactsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder contactsViewHolder, int i) {
        String fullName = userArrayList.get(i).getFirstName() + " " + userArrayList.get(i).getLastName();
        contactsViewHolder.phoneTextView.setText(userArrayList.get(i).getPhoneNumber());
        contactsViewHolder.fullNameTextView.setText(fullName);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
}

class ContactsViewHolder extends RecyclerView.ViewHolder {
    public TextView fullNameTextView, phoneTextView;
    public ImageView userImageView;

    public ContactsViewHolder(@NonNull View itemView) {
        super(itemView);
        fullNameTextView = itemView.findViewById(R.id.fullNameTextView);
        phoneTextView = itemView.findViewById(R.id.phoneNumberTextView);
        userImageView = itemView.findViewById(R.id.userImageView);
    }

}
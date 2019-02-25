package com.example.danielmoreno.androidcourse.models;

public class Contact {

    private String mFirstName;
    private String mImageId;
    private String mLastName;
    private String mPhoneNumber;

    public Contact() { }

    public Contact(String firstName, String lastName, String phoneNumber, String imageId) {
         mFirstName = firstName;
         mLastName = lastName;
         mPhoneNumber = phoneNumber;
         mImageId = imageId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getImageId() {
        return mImageId;
    }

    public void setImageId(String imageId) {
        mImageId = imageId;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

}

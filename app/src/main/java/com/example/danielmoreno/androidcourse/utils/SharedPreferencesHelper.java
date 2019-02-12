package com.example.danielmoreno.androidcourse.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

public class SharedPreferencesHelper {
    private Context mContext;
    private static final String SHARED_PREFERENCES_FILE_NAME = "com.example.danielmoreno.androidCourse.SHARED_PREFERENCES";
    private static final String USER_TOKEN_KEY = "USER_TOKEN_KEY";

    public SharedPreferencesHelper(Context context) {
        mContext = context;
    }

    /**
     * Persists user token in shared preferences
     * @param username
     * @param password
     */
    public void persistUserSession(String username, String password) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        String token = username + ";" + password;
        String encryptedToken = Base64.encodeToString(token.getBytes(), Base64.DEFAULT);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_TOKEN_KEY, encryptedToken);
        editor.apply();
    }

    /**
     * Checks if there's user data in Shared prefs
     * @return True if logged in
     */
    public boolean isUserLoggedIn() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        String encryptedToken = sharedPreferences.getString(USER_TOKEN_KEY, null);
        return encryptedToken != null;
    }

    /**
     * Log out user session
     */
    public void logoutUser() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_TOKEN_KEY, null);
        editor.apply();
    }

}

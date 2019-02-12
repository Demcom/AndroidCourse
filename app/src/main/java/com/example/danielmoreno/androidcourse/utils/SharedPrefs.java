package com.example.danielmoreno.androidcourse.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import com.example.danielmoreno.androidcourse.R;

public class SharedPrefs {
    public static final String USER_TOKEN = "USER_TOKEN_PREFS";
    private Context mContext;

    public SharedPrefs(Context context) {
        mContext = context;
    }

    public void saveUserSession(String username, String password) {
        SharedPreferences preferences = mContext.getSharedPreferences(mContext.getString(R.string.app_shared_prefs), Context.MODE_PRIVATE);
        String token = username + ";" + password;
        byte[] data = token.getBytes();
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_TOKEN, base64);
        editor.apply();
    }

    public String getUserTokenDecrypted() {
        SharedPreferences preferences = mContext.getSharedPreferences(mContext.getString(R.string.app_shared_prefs), Context.MODE_PRIVATE);
        String token = preferences.getString(USER_TOKEN, null);
        if (token == null)
            return null;

        byte[] data = Base64.decode(token, Base64.DEFAULT);
        try {
            String decryptedToken = new String(data, "UTF-8");
            return decryptedToken;
        } catch (Exception e ) {
            return null;
        }
    }
}

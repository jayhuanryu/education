package com.jjgo.education.education;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jayhuanryu on 2017. 9. 12..
 */

public class PrefUtil {

    private String TAG_PASSWORD = "PASSWORD";
    Context context;

    public PrefUtil(Context context) {
        this.context = context;
    }

    public void setPassword(String password) {
        SharedPreferences.Editor editor = context.getSharedPreferences(TAG_PASSWORD, Context.MODE_PRIVATE).edit();
        editor.putString(TAG_PASSWORD, password);
        editor.commit();
    }

    public String getPassword() {
        SharedPreferences pref = context.getSharedPreferences(TAG_PASSWORD, Context.MODE_PRIVATE);
        String password = pref.getString(TAG_PASSWORD, null);
        return password;
    }
}

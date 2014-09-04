package com.endless.callmocam.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private static final String PREFERENCE_FILE = "Preference_file";
    public static void setKeyValue(Context ctx, String key, String value) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (value == null) {
            edit.remove(key);
        } else {
            edit.putString(key, value);
        }
        edit.commit();
    }
    
    public static String getValue(Context ctx, String key) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        return sp.getString(key, null);
    }
    
}

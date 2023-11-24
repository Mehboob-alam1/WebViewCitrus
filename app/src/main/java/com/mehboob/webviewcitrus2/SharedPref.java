package com.mehboob.webviewcitrus2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private SharedPreferences sharedPreferences;
    private final String URL="url";


    public SharedPref(Context context){

        sharedPreferences=context.getSharedPreferences(URL,Context.MODE_PRIVATE);
    }

    public void saveUrl(String url){

        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(URL,url);
        editor.apply();
        editor.commit();
    }

    public String fetchUrl(){

        return sharedPreferences.getString(URL,null);
    }
}

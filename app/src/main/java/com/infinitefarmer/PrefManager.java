package com.infinitefarmer;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by guptaanirudh100 on 7/30/2017.
 */

public class PrefManager {


    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    public static void clearDb(Context paramContext) {
        if (paramContext != null) {
            SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("com.farmer", 0).edit();
            localEditor.clear();
            localEditor.commit();
        }
    }
    public static boolean isLoggedIn(Context context) {

        SharedPreferences loggedIn = context.getSharedPreferences("com.farmer", MODE_PRIVATE);
        return loggedIn.getBoolean("loggedIn", false);
    }

    public static void setLoggedIn(Boolean loggedIn, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("com.farmer", MODE_PRIVATE).edit();
        editor.putBoolean("loggedIn", loggedIn).apply();
    }
    public static void setName(String name, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("com.farmer", MODE_PRIVATE).edit();
        editor.putString("name", name).apply();
    }

    public static String getName(Context context) {
        SharedPreferences name = context.getSharedPreferences("com.farmer", MODE_PRIVATE);
        return name.getString("name", "Name");
    }

    public static void setAccessToken(String push, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("com.farmer", MODE_PRIVATE).edit();
        editor.putString("accessToken", push).apply();
    }
    public static String getAccessToken(Context context) {
        SharedPreferences name = context.getSharedPreferences("com.farmer", MODE_PRIVATE);
        return name.getString("name", null);
    }

    public static void setPhone(String phone, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("com.farmer", MODE_PRIVATE).edit();

        editor.putString("phone", phone).apply();
    }

    public static String getPhone(Context context) {
        SharedPreferences name = context.getSharedPreferences("com.farmer", MODE_PRIVATE);
        return name.getString("phone", "phone");
    }
    public static void setLanguage(String language, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("com.farmer", MODE_PRIVATE).edit();

        editor.putString("language", language).apply();
    }
    public static String getLanguage(Context context) {
        SharedPreferences name = context.getSharedPreferences("com.farmer", MODE_PRIVATE);
        return name.getString("language", "en");
    }
    public static void saveQR(String imgText, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("com.farmer", MODE_PRIVATE).edit();

        editor.putString("image", imgText).apply();
    }
    public static String getQR(Context context) {
        SharedPreferences name = context.getSharedPreferences("com.farmer", MODE_PRIVATE);
        return name.getString("image",null);
    }

    public static void setUserType(String userType, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences("com.farmer", MODE_PRIVATE).edit();

        editor.putString("user_type", userType).apply();
    }

    public static String getUserType(Context context) {
        SharedPreferences name = context.getSharedPreferences("com.farmer", MODE_PRIVATE);
        return name.getString("user_type",null);
    }


    public static void setFirstTimeLaunch(boolean isFirstTime,Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("com.farmer", MODE_PRIVATE).edit();
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public static boolean isFirstTimeLaunch(Context context) {
        SharedPreferences pref = context.getSharedPreferences("com.farmer", 0);
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }



}

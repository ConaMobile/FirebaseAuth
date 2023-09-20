package com.conamobile.firebaseauth

import android.content.Context

class MySharedPreference(context: Context) {
    private val pref = context.getSharedPreferences("shared", Context.MODE_PRIVATE)

    fun saveString(key: String, data: String) {
        pref.edit().putString(key, data).apply()
    }

    fun getString(key: String): String? {
        return pref.getString(key, null)
    }

    fun saveBoolean(key: String, data: Boolean) {
        pref.edit().putBoolean(key, data).apply()
    }

    fun getBoolean(key: String): Boolean {
        return pref.getBoolean(key, false   )
    }

}
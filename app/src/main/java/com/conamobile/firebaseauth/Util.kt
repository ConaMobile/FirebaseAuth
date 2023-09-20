package com.conamobile.firebaseauth

import android.content.Context
import android.util.Log
import android.widget.Toast

fun logcat(message: String) {
    Log.d("@@@", message)
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
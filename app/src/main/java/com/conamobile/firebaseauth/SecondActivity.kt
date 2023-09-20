package com.conamobile.firebaseauth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle = intent.extras

        // Check if the Bundle is not null
        if (bundle != null) {
            // Retrieve the boolean value using the key "key1"
            val isValueTrue = bundle.getBoolean("key1")

            if (isValueTrue) this.toast("true")
            else this.toast("false")
        }
    }
}
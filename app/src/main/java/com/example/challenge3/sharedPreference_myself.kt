package com.example.challenge3

import android.content.Context

class sharedPreference_myself(context: Context) {

    private val pref = context.getSharedPreferences("my_self", Context.MODE_PRIVATE)

    val editor = pref.edit()

    fun save_img_my_self(img: String) {

        editor.putString("img", img).apply()

    }

    fun get_img_my_self(): String? {
        return pref.getString("img", "4")

    }

    fun save_duration_my_self(duration: String) {

        editor.putString("duration", duration).apply()

    }


    fun get_duration_my_self(): String? {
        return pref.getString("duration", "120")

    }

    fun delete_myself() {

        editor.clear().commit()
    }
}
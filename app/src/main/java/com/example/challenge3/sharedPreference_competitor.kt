package com.example.challenge3

import android.content.Context

class sharedPreference_competitor(context: Context)  {

    private val pref = context.getSharedPreferences("competitor", Context.MODE_PRIVATE)

    val editor = pref.edit()

    fun save_img_competitor(img: String) {

        editor.putString("img", img).apply()

    }

    fun get_img_competitor():  String? {
        return pref.getString("img","4")

    }



    fun save_duration_competitor(duration: String) {

        editor.putString("duration", duration).apply()

    }


    fun get_duration_competitor(): String? {
        return pref.getString("duration", "150")

    }



    fun save_delay_millis_competitor(delay_millis: String) {

        editor.putString("delay_millis", delay_millis).apply()

    }


    fun get_delay_millis_competitor(): String? {
        return pref.getString("delay_millis", "250")

    }

    fun delete_competitor() {

        editor.clear().commit()
    }


}
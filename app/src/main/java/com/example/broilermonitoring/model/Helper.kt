package com.example.broilermonitoring.model

import android.content.Context
import android.content.SharedPreferences

class Helper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }
    fun saveId(Id:String){
        val editor = sharedPreferences.edit()
        editor.putString("Id",Id)
        editor.apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString("token", null)
    }

    fun getId():String?{
        return sharedPreferences.getString("Id",null)
    }

    fun clearAll() {
        val editor = sharedPreferences.edit()
        editor.remove("token")
        editor.remove("Id")
        editor.apply()
    }
}
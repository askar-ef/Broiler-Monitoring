package com.example.broilermonitoring.model

import android.content.Context
import android.content.SharedPreferences

class Helper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveUser(user: Profile) {
        val editor = sharedPreferences.edit()
        editor.putString("user_namaLengkap", user.namaLengkap)
        editor.putString("user_userndsssssssssssssssame", user.username)
        editor.putString("user_status", user.status)
        editor.apply()
    }

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
    fun saveIdKandang(IdKandang:Int){
        val editor=sharedPreferences.edit()
        editor.putInt("IdKandang",IdKandang)
        editor.apply()
    }

    fun saveStatus(status: String) {
        val editor = sharedPreferences.edit()
        editor.putString("status", status)
        editor.apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString("token", null)
    }

    fun getId():String?{
        return sharedPreferences.getString("Id",null)
    }
    fun getIdKandang():Int{
        return sharedPreferences.getInt("IdKandang", 0)
    }

    fun getStatus(): String? {
        return sharedPreferences.getString("status", null)
    }

    fun getUser(): Profile? {
        val namaLengkap = sharedPreferences.getString("user_namaLengkap",null)
        val username = sharedPreferences.getString("user_username",null)
        val status = sharedPreferences.getString("user_status",null)
        val user = Profile(namaLengkap,null,username,status,null)

        return user
    }

    fun clearAll() {
        val editor = sharedPreferences.edit()
        editor.remove("token")
        editor.remove("Id")
        editor.remove("IdKandang")
        editor.remove("status")
        editor.remove("user_namaLengkap")
        editor.remove("user_username")
        editor.remove("user_status")
        editor.apply()
    }
}
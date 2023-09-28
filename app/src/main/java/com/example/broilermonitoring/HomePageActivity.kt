package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)
        val spinner = findViewById<Spinner>(R.id.kandang) // Replace with your Spinner's ID
        val customAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.kandang, // Replace with your Spinner's item array resource
            R.layout.spinner_item // Use the custom layout you created
        )

        customAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = customAdapter
    }
}
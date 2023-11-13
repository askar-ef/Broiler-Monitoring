package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.AkunBinding

class AkunActivity : AppCompatActivity() {
    private lateinit var binding: AkunBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AkunBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            changePhoto.setOnClickListener {

            }
        }
    }
}
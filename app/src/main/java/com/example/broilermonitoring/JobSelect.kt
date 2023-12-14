package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.broilermonitoring.Pemilik.MainPemilik
import com.example.broilermonitoring.databinding.ActivityJobSelectBinding
import com.example.broilermonitoring.login.LoginPage
import com.example.broilermonitoring.model.Helper

class JobSelect : AppCompatActivity() {
    private lateinit var binding: ActivityJobSelectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityJobSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            nextButton.setOnClickListener {
                val checkedButton = toggle.checkedRadioButtonId

                val helper = Helper(this@JobSelect)

                //ID Owner 2131362242
                if (checkedButton == 2131362242){
                    val intent= Intent(this@JobSelect, LoginPage::class.java)
                    helper.saveStatus("owner")
                    startActivity(intent)
                }else{
                    val intent=Intent(this@JobSelect, LoginPage::class.java)
                    helper.saveStatus("anak kandang")
                    startActivity(intent)
                }
            }
        }
    }
}
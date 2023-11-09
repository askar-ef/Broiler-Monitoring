package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.ActivityJobSelectBinding

class JobSelect : AppCompatActivity() {
    private lateinit var binding: ActivityJobSelectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityJobSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            nextButton.setOnClickListener {
                val checkedButton=toggle.checkedRadioButtonId

                if (checkedButton.equals(peternakButton)){
                    val intent= Intent(this@JobSelect,LoginPage::class.java)
                    intent.putExtra("EXTRA_STATUS","owner")
                    startActivity(intent)
                }else{
                    val intent=Intent(this@JobSelect,LoginPage::class.java)
                    intent.putExtra("EXTRA_STATUS","anak kandang")
                    startActivity(intent)
                }
            }
        }
    }
}
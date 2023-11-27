package com.example.broilermonitoring.Pemilik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.TambahKandangBinding
import com.google.android.material.textfield.TextInputEditText

class TambahKandang : AppCompatActivity() {
    private lateinit var binding: TambahKandangBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ADDRESS = "extra_address"
        const val EXTRA_LUAS = "extra_luas"
        const val EXTRA_POPULASI = "extra_populasi"
        const val EXTRA_ANAK = "extra_anak"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TambahKandangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowBack.setOnClickListener {
            onBackPressed()
        }

        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.anak_kandang)
        val namaKandang = findViewById<TextInputEditText>(R.id.nama_kandang)
        val alamatKandang = findViewById<TextInputEditText>(R.id.alamat_kandang)
        val luasKandang = findViewById<TextInputEditText>(R.id.luas_kandang)
        val populasiAyam = findViewById<TextInputEditText>(R.id.populasi_ayam)

        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items)

        autoCompleteTextView.setAdapter(adapter)

        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = adapter.getItem(position)
            // Handle the selected item
        }

        binding.button.setOnClickListener{
            val intent = Intent(this, HomePemilik::class.java)
            intent.putExtra(EXTRA_NAME, namaKandang.text.toString())
            intent.putExtra(EXTRA_ADDRESS, alamatKandang.text.toString())
            intent.putExtra(EXTRA_LUAS, luasKandang.text.toString())
            intent.putExtra(EXTRA_POPULASI, populasiAyam.text.toString())
            intent.putExtra(EXTRA_ANAK, autoCompleteTextView.text.toString())
            startActivity(intent)
        }
    }
}
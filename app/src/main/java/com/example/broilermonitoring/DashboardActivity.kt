package com.example.broilermonitoring

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
class DashboardActivity : AppCompatActivity() {
    internal var status = 0
    private val handler = Handler()
    lateinit var textView: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
        title = "KotlinApp"
        val resources = resources
        val drawable = resources.getDrawable(R.drawable.progress)
        val progressBar: ProgressBar = findViewById(R.id.progress_suhu)
        progressBar.progress = 0
        progressBar.secondaryProgress = 100
        progressBar.max = 100
        progressBar.progressDrawable = drawable
        textView = findViewById(R.id.suhu)
        Thread {
            while (status < 100) {
                status += 1
                handler.post {
                    progressBar.progress = status
                    textView.text = String.format("%d%%", status)
                }
                try {
                    Thread.sleep(16)
                }
                catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }
}
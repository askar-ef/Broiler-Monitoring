package com.example.broilermonitoring.Pemilik

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.PemilikForecastingBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class Forecasting : AppCompatActivity() {
    private lateinit var binding: PemilikForecastingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PemilikForecastingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val barChart: BarChart = binding.grafikForcasting

        // Sample data
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 10f))
        entries.add(BarEntry(2f, 20f))
        entries.add(BarEntry(3f, 30f))
        entries.add(BarEntry(4f, 40f))
        entries.add(BarEntry(5f, 50f))

        val dataSet = BarDataSet(entries, "Sample Data")
        dataSet.color = Color.BLUE

        val barData = BarData(dataSet)

        barChart.data = barData

        // Customize X-axis
        val xAxis: XAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        // Refresh the chart
        barChart.invalidate()
    }
}
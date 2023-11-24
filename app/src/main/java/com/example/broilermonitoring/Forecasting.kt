package com.example.broilermonitoring

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class Forecasting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forecasting)
        val barChart: BarChart = findViewById(R.id.barChart)

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
package com.example.graphviewer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.charts.RadarChart

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val pieChartView = findViewById<PieChart>(R.id.radar_graphic)
        val pie = com.example.graphviewer.graphs.PieChart(pieChartView,this.applicationContext)
        pie.setPieChartData()

        val radarChartView = findViewById<RadarChart>(R.id.radar_graphic)
        val radar = com.example.graphviewer.graphs.RadarChart(radarChartView,this.applicationContext)
        radar.setRadarChartData()
    }
}
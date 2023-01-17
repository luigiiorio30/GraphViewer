package com.example.graphviewer.graphs

import android.content.Context
import android.graphics.Color
import com.example.graphviewer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet

class RadarChart(private val radarChartView: RadarChart, private val radarContext: Context) {

    lateinit var radarChart: RadarChart
    lateinit var radarData: RadarData
    lateinit var radarDataSet: RadarDataSet
    lateinit var radarEntriesList: ArrayList<RadarEntry>

    fun setRadarChartData() {
        getRadarChartData()
        radarChart = radarChartView.findViewById(R.id.pie_graphic)

        radarChart.webLineWidth = 1f
        radarChart.webColor = Color.LTGRAY
        radarChart.webLineWidthInner = 1f
        radarChart.webColorInner = Color.LTGRAY
        radarChart.webAlpha = 100

        val xAxis = radarChart.xAxis
        xAxis.textSize = 9f
        xAxis.yOffset = 0f
        xAxis.xOffset = 0f
        xAxis.valueFormatter = object : ValueFormatter() {
            private val mActivities = arrayOf("Data 1", "Data 2", "Data 3")

            override fun getFormattedValue(value: Float): String {
                return mActivities[value.toInt() % mActivities.size]
            }
        }
        xAxis.textColor = Color.BLACK

        val yAxis = radarChart.yAxis
        yAxis.setLabelCount(5, false)
        yAxis.textSize = 9f
        yAxis.axisMinimum = 0f
        yAxis.axisMaximum = 80f
        yAxis.setDrawLabels(false)

        radarDataSet = RadarDataSet(radarEntriesList, "Data Set")
        radarDataSet.color = Color.BLACK
        radarDataSet.fillColor = Color.BLACK
        radarDataSet.setDrawFilled(true)
        radarDataSet.fillAlpha = 180
        radarDataSet.lineWidth = 2f
        radarDataSet.setDrawHighlightIndicators(false)

        val sets: MutableList<IRadarDataSet> = ArrayList()
        sets.add(radarDataSet)
        radarChart.data = radarData
        radarChart.description.isEnabled = false
        radarChart.legend.isEnabled = false

        radarChart.animateXY(
            1400, 1400,
            Easing.EaseInOutQuad
        )

        radarChart.invalidate()
    }

    private fun getRadarChartData() {
        radarEntriesList = ArrayList()
        radarEntriesList.add(RadarEntry(70f))
        radarEntriesList.add(RadarEntry(60f))
        radarEntriesList.add(RadarEntry(50f))
    }
}
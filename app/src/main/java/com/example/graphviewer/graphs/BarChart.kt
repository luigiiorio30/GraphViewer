package com.example.graphviewer.graphs

import android.content.Context
import android.graphics.Color
import com.example.graphviewer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet

class BarChart(private val barChartView: BarChart, private val barContext: Context) {

    lateinit var barChart: BarChart
    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barEntriesList: ArrayList<BarEntry>

    fun setBarChartData() {
        barData = BarData()
        getBarChartData()
        barChart = barChartView.findViewById(R.id.bar_graphic)

        val xAxis = barChart.xAxis
        xAxis.textSize = 9f
        xAxis.yOffset = 0f
        xAxis.xOffset = 0f
        xAxis.valueFormatter = object : ValueFormatter() {
            private val mActivities = arrayOf("Data 1", "Data 2", "Data 3", "Data 4", "Data 5")

            override fun getFormattedValue(value: Float): String {
                return mActivities[value.toInt() % mActivities.size]
            }
        }
        xAxis.textColor = Color.BLACK

        val leftAxis = barChart.axisLeft
        leftAxis.setLabelCount(5, false)
        leftAxis.textSize = 9f
        leftAxis.axisMinimum = 0f
        leftAxis.axisMaximum = 80f
        leftAxis.setDrawLabels(false)

        barDataSet = BarDataSet(barEntriesList, "Data Set")
        barDataSet.color = Color.YELLOW
        barDataSet.barBorderColor = Color.RED
        barDataSet.barBorderWidth = 2f


        val sets: MutableList<IBarDataSet> = ArrayList()
        sets.add(barDataSet)
        barData = BarData(barDataSet)
        barChart.data = barData
        barChart.description.isEnabled = false
        barChart.legend.isEnabled = false

        barChart.animateY(
            1400, Easing.EaseInOutQuad
        )

        barChart.invalidate()
    }

    private fun getBarChartData() {
        barEntriesList = ArrayList()

        barDataSet = BarDataSet(barEntriesList, "Data Set")
        barEntriesList.add(BarEntry(0f, 30f))
        barEntriesList.add(BarEntry(1f, 60f))
        barEntriesList.add(BarEntry(2f, 45f))
        barEntriesList.add(BarEntry(3f, 75f))
        barEntriesList.add(BarEntry(4f, 10f))
    }
}
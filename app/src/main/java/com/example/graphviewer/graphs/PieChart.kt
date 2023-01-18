package com.example.graphviewer.graphs

import android.content.Context
import android.graphics.Color
import com.example.graphviewer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet

class PieChart(private val pieChartView: PieChart, private val pieContext: Context) {

    lateinit var pieChart: PieChart
    lateinit var pieData: PieData
    lateinit var pieDataSet: PieDataSet
    lateinit var pieEntriesList: ArrayList<PieEntry>

    fun setPieChartData() {
        pieData = PieData()
        getPieChartData()
        pieChart = pieChartView.findViewById(R.id.pie_graphic)

        val legend = pieChart.legend
        legend.textSize = 12f
        legend.form = Legend.LegendForm.CIRCLE


        pieDataSet.colors = listOf(Color.YELLOW, Color.RED, Color.BLUE, Color.GREEN, Color.GRAY)
        pieDataSet.valueTextSize = 12f
        pieDataSet.sliceSpace = 3f
        pieDataSet.valueFormatter = PercentFormatter()

        val sets: MutableList<IPieDataSet> = ArrayList()
        sets.add(pieDataSet)
        pieData = PieData(pieDataSet)
        pieChart.data = pieData
        pieChart.description.isEnabled = false
        pieChart.legend.isEnabled = true

        pieChart.animateY(
            1400, Easing.EaseInOutQuad
        )

        pieChart.invalidate()
    }

    private fun getPieChartData() {
        pieEntriesList = ArrayList()
        pieDataSet = PieDataSet(pieEntriesList, "Data Set")

        pieEntriesList.add(PieEntry(30f, "Data 1"))
        pieEntriesList.add(PieEntry(60f, "Data 2"))
        pieEntriesList.add(PieEntry(45f, "Data 3"))
        pieEntriesList.add(PieEntry(75f, "Data 4"))
        pieEntriesList.add(PieEntry(10f, "Data 5"))
    }
}
package com.example.graphviewer.graphs

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import com.example.graphviewer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF

class PieChart(private val pieChartView: PieChart, private val pieContext: Context) {
    lateinit var pieChart: PieChart

    lateinit var pieData: PieData
    lateinit var pieDataSet: PieDataSet
    lateinit var pieEntriesList: ArrayList<PieEntry>

    fun setPieChartData() {

        pieChart = pieChartView.findViewById(R.id.pie_graphic)

        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.dragDecelerationFrictionCoef = 0.95f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)
        pieChart.setTransparentCircleColor(Color.WHITE)
        pieChart.setTransparentCircleAlpha(110)
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.setDrawCenterText(true)
        pieChart.rotationAngle = 0f
        pieChart.isRotationEnabled = true
        pieChart.isHighlightPerTapEnabled = true

        pieChart.animateY(1400, Easing.EaseInOutQuad)

        pieChart.legend.isEnabled = false
        pieChart.setEntryLabelColor(Color.WHITE)
        pieChart.setEntryLabelTextSize(12f)
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(70f))
        entries.add(PieEntry(20f))
        entries.add(PieEntry(10f))

        val dataSet = PieDataSet(entries, "Mobile OS")

        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        val colors: ArrayList<Int> = ArrayList()
        colors.add(pieContext.resources.getColor(R.color.purple_200))
        colors.add(pieContext.resources.getColor(R.color.purple_500))
        colors.add(pieContext.resources.getColor(R.color.purple_700))

        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        pieChart.data = data
        pieChart.highlightValues(null)
        pieChart.invalidate()

    }

    /**
     * Private function to add data to the list of items in our bar
     */
    private fun getPieChartData() {
        pieEntriesList = ArrayList()
        pieEntriesList.add(PieEntry(1.0f, 1.0f))
        pieEntriesList.add(PieEntry(5.0f, 5.0f))
        pieEntriesList.add(PieEntry(4.0f, 4.0f))

    }
}
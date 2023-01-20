package com.example.graphviewer.graphs

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Color.*
import android.graphics.Typeface
import com.example.graphviewer.R
import com.example.graphviewer.dataSet.PieChartDataSet
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF

class PieChart(private val pieChartView: PieChart, private val pieContext: Context, dataList: List<Int>) {

    var setData = PieChartDataSet(dataList)

    lateinit var pieChart: PieChart
    lateinit var pieData: PieData
    lateinit var pieDataSet: PieDataSet
    lateinit var pieEntriesList: ArrayList<PieEntry>

    @SuppressLint("ResourceType")
    fun setPieChartData() {

        val legend = pieChart.legend
        legend.textSize = 12f
        legend.form = Legend.LegendForm.CIRCLE

        pieDataSet.colors = listOf(YELLOW, RED, BLUE, GREEN, GRAY)
        pieDataSet.valueTextSize = 12f
        pieDataSet.sliceSpace = 3f
        pieDataSet.valueFormatter = PercentFormatter()

        pieChart = pieChartView.findViewById(R.id.pie_graphic)
        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.dragDecelerationFrictionCoef = 0.95f
        pieChart.isDrawHoleEnabled = false
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
        pieChart.setEntryLabelTextSize(16f)

        val entries: ArrayList<PieEntry> = setData.setDataPieChart()
        val dataSet = PieDataSet(entries, "Data")

        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        val colors: ArrayList<Int> = ArrayList()
        colors.add(pieContext.resources.getColor(RED))
        colors.add(pieContext.resources.getColor(GREEN))
        colors.add(pieContext.resources.getColor(BLUE))
        colors.add(pieContext.resources.getColor(GRAY))
        colors.add(pieContext.resources.getColor(YELLOW))
        colors.add(pieContext.resources.getColor(YELLOW))
        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        pieChart.data = data
        pieChart.highlightValues(null)
        pieChart.animateXY(2000,2000)
        pieChart.invalidate()

    }
}
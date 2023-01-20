package com.example.graphviewer.dataSet

import com.github.mikephil.charting.data.PieEntry
import kotlin.collections.ArrayList

class PieChartDataSet(private val dataList: List<Int>) {

    fun setDataPieChart(): ArrayList<PieEntry> {
        val dataPie = dataList
        val entries: ArrayList<PieEntry> = ArrayList()
        for (i in dataPie.indices) {
            entries.add(PieEntry(dataPie[i].toFloat()))
        }
        return entries
    }
}
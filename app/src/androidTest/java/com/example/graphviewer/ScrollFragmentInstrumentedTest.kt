package com.example.graphviewer

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ScrollFragmentTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun click_button_to_chart (){
        enableWifi(true)
        enableCellularData(true)
        Thread.sleep(500)
        clickId(R.id.radar_button)
        Thread.sleep(500)
        clickId(R.id.pie_button)
        Thread.sleep(1000)
        clickId(R.id.bar_button)
        Thread.sleep(4000)
    }

    @Test
    fun check_if_charts_are_visible (){
        enableWifi(true)
        enableCellularData(true)
        Thread.sleep(500)
        clickId(R.id.radar_button)
        Thread.sleep(500)
        checkIfVisible(R.id.radar_graphic) //check
        Thread.sleep(500)
        clickId(R.id.pie_button)
        Thread.sleep(500)
        checkIfVisible(R.id.pie_graphic) // check
        Thread.sleep(500)
        clickId(R.id.bar_button)
        Thread.sleep(500)
        checkIfVisible(R.id.bar_graphic)
        Thread.sleep(4000)
    }

}

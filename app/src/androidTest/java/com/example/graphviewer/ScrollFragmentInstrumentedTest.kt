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
        Thread.sleep(500)
        clickId(R.id.radar_button)
        Thread.sleep(4000)
    }
}

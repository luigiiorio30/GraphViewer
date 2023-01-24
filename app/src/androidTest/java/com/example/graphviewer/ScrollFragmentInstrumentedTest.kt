package com.example.graphviewer

import androidx.navigation.NavController
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito


@RunWith(AndroidJUnit4::class)
class ScrollFragmentTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)
    val mockNavController = Mockito.mock(NavController::class.java)!!

    @Test
    fun click_button_to_chart (){
        enableWifi(true)
        Thread.sleep(500)
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

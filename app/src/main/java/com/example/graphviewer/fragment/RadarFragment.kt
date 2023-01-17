package com.example.graphviewer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.graphviewer.R
import com.example.graphviewer.databinding.FragmentChartRadarBinding
import com.github.mikephil.charting.charts.RadarChart

/**
 * A simple [Fragment] subclass.
 * Use the [PieChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RadarFragment : Fragment() {

    private var _binding: FragmentChartRadarBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChartRadarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val radarChartView = view.findViewById<RadarChart>(R.id.radar_graphic)
        val radar = context?.let { com.example.graphviewer.graphs.RadarChart(radarChartView, it) }
        with(radar) {
            this?.setRadarChartData()
        }
    }

}
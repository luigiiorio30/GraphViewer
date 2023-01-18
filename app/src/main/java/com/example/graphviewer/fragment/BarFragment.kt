package com.example.graphviewer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.graphviewer.R
import com.example.graphviewer.databinding.FragmentChartBarBinding
import com.github.mikephil.charting.charts.BarChart

/**
 * A simple [Fragment] subclass.
 * Use the [BarChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BarFragment : Fragment() {

    private var _binding: FragmentChartBarBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChartBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val barChartView = view.findViewById<BarChart>(R.id.bar_graphic)
        val bar = context?.let { com.example.graphviewer.graphs.BarChart(barChartView, it) }
        with(bar) {
            this?.setBarChartData()
        }
    }

}
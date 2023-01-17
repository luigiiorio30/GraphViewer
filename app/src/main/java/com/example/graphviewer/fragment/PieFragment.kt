package com.example.graphviewer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.graphviewer.R
import com.example.graphviewer.databinding.FragmentChartPieBinding
import com.github.mikephil.charting.charts.PieChart

/**
 * A simple [Fragment] subclass.
 * Use the [PieChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PieFragment : Fragment() {

    private var _binding: FragmentChartPieBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChartPieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pieChartView = view.findViewById<PieChart>(R.id.pie_chart)
        val pie = context?.let { com.example.graphviewer.graphs.PieChart(pieChartView, it) }
        with(pie) {
            this?.setPieChartData()
        }
    }

}
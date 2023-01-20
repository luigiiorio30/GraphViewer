package com.example.graphviewer.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.graphviewer.R
import com.example.graphviewer.databinding.FragmentChartPieBinding
import com.example.graphviewer.fragment.viewmodel.PieViewModel
import com.example.graphviewer.net.PieInfo
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend

/**
 * A simple [Fragment] subclass.
 * Use the [PieChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class PieFragment : Fragment() {
    private val viewModel: PieViewModel by viewModels()

    private var _binding: FragmentChartPieBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChartPieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.dataPieAcquisition()
        val pieChartView = view.findViewById<PieChart>(R.id.pie_graphic)
        val observer = Observer<List<PieInfo>> { _ ->
            val pie = context?.let {
                com.example.graphviewer.graphs.PieChart(
                    pieChartView,
                    it,
                    viewModel.getDataPie()
                )
            }
            with(pie) {
                this?.setPieChartData()
            }
        }
        val legend = pieChartView.legend
        legend.form = Legend.LegendForm.CIRCLE
        legend.formSize = 20f
        legend.textColor = Color.BLACK
        legend.textSize = 18f
        legend.xEntrySpace = 5f
        legend.yEntrySpace = 5f
        legend.isEnabled = true
        viewModel.pie.observe(viewLifecycleOwner, observer)
    }
}


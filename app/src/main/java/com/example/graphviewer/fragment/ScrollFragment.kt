package com.example.graphviewer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.graphviewer.databinding.FragmentScrollViewBinding

class ScrollFragment : Fragment() {

    private var _binding: FragmentScrollViewBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScrollViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pager: ViewPager = binding.pager

        pager.offscreenPageLimit = 2
        pager.adapter = PageAdapter(activity?.supportFragmentManager)
    }


    private class PageAdapter(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            var fragment: Fragment = RadarFragment()
            when (position) {
                0 -> fragment = RadarFragment()
                1 -> fragment = PieFragment()
                else -> fragment = RadarFragment()
            }
            return fragment
        }

        override fun getCount(): Int {
            return 2
        }
    }



}
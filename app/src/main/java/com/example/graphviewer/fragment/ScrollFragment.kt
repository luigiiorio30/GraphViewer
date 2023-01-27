package com.example.graphviewer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.graphviewer.R
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

        binding.radarButton.setOnClickListener {
            val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_container, RadarFragment())
            fragmentTransaction?.addToBackStack(null)
            binding.infoText.visibility= View.INVISIBLE
            binding.imageAlert.visibility= View.INVISIBLE
            binding.welcome.visibility= View.INVISIBLE
            binding.imageWelcome.visibility= View.INVISIBLE
            fragmentTransaction?.commit()
        }
        binding.pieButton.setOnClickListener {
            val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_container, PieFragment())
            fragmentTransaction?.addToBackStack(null)
            binding.infoText.visibility= View.INVISIBLE
            binding.imageAlert.visibility= View.INVISIBLE
            binding.welcome.visibility= View.INVISIBLE
            binding.imageWelcome.visibility= View.INVISIBLE
            fragmentTransaction?.commit()
        }
        binding.barButton.setOnClickListener {
            val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_container, BarFragment())
            fragmentTransaction?.addToBackStack(null)
            binding.infoText.visibility= View.INVISIBLE
            binding.imageAlert.visibility= View.INVISIBLE
            binding.welcome.visibility= View.INVISIBLE
            binding.imageWelcome.visibility= View.INVISIBLE
            fragmentTransaction?.commit()
        }
        binding.delButton.setOnClickListener {
            val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
            activity?.supportFragmentManager?.findFragmentById(R.id.fragment_container)
                ?.let { it1 -> fragmentTransaction?.remove(it1) }
            binding.infoText.visibility= View.VISIBLE
            binding.imageAlert.visibility= View.VISIBLE
            binding.welcome.visibility= View.INVISIBLE
            binding.imageWelcome.visibility= View.INVISIBLE
            fragmentTransaction?.commit()
        }
    }
}

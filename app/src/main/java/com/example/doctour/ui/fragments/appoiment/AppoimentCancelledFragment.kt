package com.example.doctour.ui.fragments.appoiment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.doctour.databinding.FragmentAppoimentCancelledBinding

class AppoimentCancelledFragment : Fragment() {

    private lateinit var binding: FragmentAppoimentCancelledBinding
    private lateinit var appoimentCancelledAdapter: AppoimentCancelledAdapter
    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppoimentCancelledBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showTabs()
    }

    private fun showTabs() {
        appoimentCancelledAdapter = AppoimentCancelledAdapter(this)
        viewPager2 = binding.viewpager2
        viewPager2.adapter = appoimentCancelledAdapter
        val tablayout = binding.tabLayout
        tablayout.addTab(tablayout.newTab().setText("Предстоящий"))
        tablayout.addTab(tablayout.newTab().setText("Завершенный"))
        tablayout.addTab(tablayout.newTab().setText("Отмененный"))
    }
}

package com.example.doctour.ui.fragments.appoiment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentCancelledBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AppoimentCancelledFragment : Fragment() {
    private lateinit var binding: FragmentAppoimentCancelledBinding
    private lateinit var appoimentCancelledAdapter: AppoimentCancelledAdapter
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAppoimentCancelledBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showTabs()
        onClickListeners()
    }

    private fun onClickListeners() {
        binding.tvArrowBack.setOnClickListener {
            // findNavController().navigateUp()
        }
    }

    private fun showTabs() {
        appoimentCancelledAdapter = AppoimentCancelledAdapter(this)
        viewPager2 = binding.viewpager2
        viewPager2.adapter = appoimentCancelledAdapter
        tabLayout = binding.tabLayout
        val tabNames = arrayListOf(
            getString(R.string.upcoming),
            getString(R.string.completed),
            getString(R.string.cancelled)
        )
        TabLayoutMediator(tabLayout, viewPager2) { tab, pos ->
            tab.text = tabNames[pos]
        }.attach()
    }
}

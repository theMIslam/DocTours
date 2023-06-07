package com.example.doctour.presentation.ui.fragments.appoiment

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentCancelledBinding
import com.example.doctour.presentation.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppoimentCancelledFragment :
    BaseFragment<FragmentAppoimentCancelledBinding, AppoimentViewModel>
        (R.layout.fragment_appoiment_cancelled) {

    override val binding: FragmentAppoimentCancelledBinding by viewBinding(FragmentAppoimentCancelledBinding::bind)
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()

    private lateinit var appoimentCancelledAdapter: AppoimentCancelledAdapter
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun initListeners() {
        super.initListeners()
        showTabs()
        onClickListeners()
    }

    private fun onClickListeners() {
        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
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

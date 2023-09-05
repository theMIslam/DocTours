package com.example.doctour.presentation.ui.fragments.main.onboarding

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.base.BaseViewModel
import com.example.doctour.databinding.FragmentOnBoardingBinding
import com.example.doctour.presentation.ui.adapter.onBoarding.AdapterBoardingFragment

class OnBoardingFragment : BaseFragment<FragmentOnBoardingBinding,BaseViewModel> (R.layout.fragment_on_boarding) {

    override val binding: FragmentOnBoardingBinding by viewBinding(FragmentOnBoardingBinding::bind)
    override val viewModel: BaseViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        val adapter = AdapterBoardingFragment(this,this::onSkipClick,this ::onNextClick )
        binding.viewpager2.adapter= adapter

        binding.indicator.setViewPager(binding.viewpager2)
        binding.indicator.createIndicators(3,0)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }

    private  fun onSkipClick(){
        binding.viewpager2.currentItem =2
    }
    private fun onNextClick(){
        binding.viewpager2.currentItem +=1
    }


}

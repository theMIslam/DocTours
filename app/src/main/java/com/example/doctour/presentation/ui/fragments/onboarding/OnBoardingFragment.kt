package com.example.doctour.presentation.ui.fragments.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentOnBoardingBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.ui.fragments.onboarding.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class OnBoardingFragment : BaseFragment<FragmentOnBoardingBinding,OnBoardViewModel>(
    R.layout.fragment_on_boarding
) {
    override val binding: FragmentOnBoardingBinding by viewBinding(FragmentOnBoardingBinding::bind)
    override val viewModel: OnBoardViewModel by viewModels<OnBoardViewModel>()

    override fun initialize() {
        super.initialize()
        val adapter= OnBoardingAdapter()
        binding.viewpager2.adapter = adapter
    }

}
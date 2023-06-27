package com.example.doctour.presentation.ui.fragments.main.review

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentAboutDoctorReviewBinding
import com.example.doctour.presentation.ui.fragments.main.aboutdoctor.AboutDoctorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class AboutDoctorReviewFragment :
    BaseFragment<FragmentAboutDoctorReviewBinding, AboutDoctorViewModel>(
    R.layout.fragment_about_doctor_review
) {

    override val binding: FragmentAboutDoctorReviewBinding by viewBinding(FragmentAboutDoctorReviewBinding::bind)
    override val viewModel: AboutDoctorViewModel by viewModels<AboutDoctorViewModel>()
    override fun initListeners() {
        super.initListeners()

        binding.btnWriteFb.setOnClickListener {
           findNavController().navigate(R.id.aboutDoctorFragment)
        }

        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }



}
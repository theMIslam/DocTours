package com.example.doctour.presentation.ui.fragments.review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAboutDoctorReviewBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.ui.fragments.aboutdoctor.AboutDoctorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class AboutDoctorReviewFragment :BaseFragment<FragmentAboutDoctorReviewBinding,AboutDoctorViewModel>(
    R.layout.fragment_about_doctor_review
) {

    override val binding: FragmentAboutDoctorReviewBinding by viewBinding(FragmentAboutDoctorReviewBinding::bind)
    override val viewModel: AboutDoctorViewModel by viewModels<AboutDoctorViewModel>()
    override fun initListeners() {
        super.initListeners()
        clickers()
    }

    private fun clickers() {

    }


}
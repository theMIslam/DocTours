package com.example.doctour.presentation.ui.fragments.main.review

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentAboutDoctorReviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class AboutDoctorReviewFragment :
    BaseFragment<FragmentAboutDoctorReviewBinding, ReviewViewModel>(
        R.layout.fragment_about_doctor_review
    ) {

    override val binding: FragmentAboutDoctorReviewBinding by viewBinding(
        FragmentAboutDoctorReviewBinding::bind
    )
    override val viewModel: ReviewViewModel by viewModels()
    private val adapterAboutDoctorReview = AdapterAboutDoctorReview()

    override fun initRequest() {
        super.initRequest()
        adapterAboutDoctorReview.addLoadStateListener { loadState ->
            binding.rvReviews.isVisible = loadState.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadState.refresh is LoadState.NotLoading
        }
        getReviewsPaging()
    }

    private fun getReviewsPaging() {
        viewModel.getReviews().collectPaging {
            adapterAboutDoctorReview.submitData(it)
        }
    }

    override fun initialize() {
        super.initialize()
        binding.rvReviews.adapter = adapterAboutDoctorReview
        binding.rvReviews.layoutManager = LinearLayoutManager(requireContext())
    }

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
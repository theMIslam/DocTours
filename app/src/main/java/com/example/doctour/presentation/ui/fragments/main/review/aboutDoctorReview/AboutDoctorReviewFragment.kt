package com.example.doctour.presentation.ui.fragments.main.review.aboutDoctorReview

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentAboutDoctorReviewBinding
import com.example.doctour.presentation.ui.fragments.main.review.ReviewViewModel
import com.example.doctour.presentation.ui.fragments.main.review.aboutDoctorReview.adapter.AboutDoctorReviewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class AboutDoctorReviewFragment :
    BaseFragment<FragmentAboutDoctorReviewBinding, ReviewViewModel>(
        R.layout.fragment_about_doctor_review
    ) {

    override val binding: FragmentAboutDoctorReviewBinding by viewBinding(FragmentAboutDoctorReviewBinding::bind)
    override val viewModel: ReviewViewModel by viewModels()
    private lateinit var adapterAboutDoctorReview : AboutDoctorReviewAdapter

    override fun initRequest() {
        super.initRequest()
        getReviewsPaging()
    }

    private fun getReviewsPaging() {
        viewModel.getReviews().collectPaging {
            adapterAboutDoctorReview.submitData(it)
        }
    }

    override fun initialize() {
        super.initialize()
        binding.rvReviews.layoutManager = LinearLayoutManager(requireContext())
        adapterAboutDoctorReview= AboutDoctorReviewAdapter()
        binding.rvReviews.adapter = adapterAboutDoctorReview
        adapterAboutDoctorReview.addLoadStateListener { loadState ->
            binding.rvReviews.isVisible = loadState.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadState.refresh is LoadState.Loading
        }

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
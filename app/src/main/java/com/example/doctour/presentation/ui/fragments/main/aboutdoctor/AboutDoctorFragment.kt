package com.example.doctour.presentation.ui.fragments.main.aboutdoctor

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentAboutDoctorBinding
import com.example.doctour.presentation.model.DoctorDetailUi
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.ui.fragments.main.aboutdoctor.adapter.FeedbacksAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutDoctorFragment
    : BaseFragment<FragmentAboutDoctorBinding, AboutDoctorViewModel>(
    R.layout.fragment_about_doctor
) {

    override val binding: FragmentAboutDoctorBinding by viewBinding(FragmentAboutDoctorBinding::bind)
    override val viewModel: AboutDoctorViewModel by viewModels()
    private val adapterFeedback: FeedbacksAdapter by lazy {
        FeedbacksAdapter()
    }

    override fun initialize() {
        super.initialize()
        binding.rvFeedbacks.adapter = adapterFeedback
    }

    override fun initListeners() {
        super.initListeners()

        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.tvAllReviews.setOnClickListener {
            findNavController().navigate(R.id.aboutDoctorReviewFragment)
        }
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.bookingToDoctorSecondFragment)
        }
        binding.ivHeart.setOnClickListener {

        }
    }

    private fun  getInfoAboutDoctor(){
        val data = this.arguments?.getSerializable("key") as DoctorDetailUi
        binding.tvNameOfDoctor.text = "Врач ${data.full_name}"
        data.photo?.let { binding.image.loadImage(it) }
        binding.name.text = data.full_name
       // binding.tvSurgeon.text = data.specialties
        //binding.tvClinic.text = data.clinic
        binding.tvPrice.text = data.price.toString()
        binding.tvNumOfExperience.text = data.experience.toString()
        binding.tvNumOfRating.text = data.average_rating
        binding.tvNumOfFeedback.text = data.num_reviews
        binding.tvInfoAboutDoc.text = data.summary

    }

}
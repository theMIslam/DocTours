package com.example.doctour.presentation.ui.fragments.aboutdoctor

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAboutDoctorBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.ui.fragments.appoiment.model.BermetModel
import com.example.doctour.utils.loadImage

class AboutDoctorFragment
    : BaseFragment<FragmentAboutDoctorBinding, AboutDoctorViewModel>(
    R.layout.fragment_about_doctor
) {

    override val binding: FragmentAboutDoctorBinding by viewBinding(FragmentAboutDoctorBinding::bind)
    override val viewModel: AboutDoctorViewModel by viewModels<AboutDoctorViewModel>()
    private val adapterFeedback: AdapterFeedbacks by lazy {
        AdapterFeedbacks()
    }

    override fun initListeners() {
        super.initListeners()
        binding.rvFeedbacks.adapter = adapterFeedback

        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.tvAllReviews.setOnClickListener {
            findNavController().navigate(R.id.aboutDoctorReviewFragment)
        }
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.bookingToDoctorFragment)
        }
        binding.ivHeart.setOnClickListener {
            findNavController().navigate(R.id.bookingToDoctorFragment)
        }
    }

    private fun getData() {
        val data = this.arguments?.getSerializable("key") as BermetModel
        binding.tvNameOfDoctor.text = "Врач ${data.name}"
        binding.image.loadImage(data.image)
        binding.name.text = data.name
        binding.tvSurgeon.text = data.profession
        binding.tvClinic.text = data.clinic
        binding.tvPrice.text = data.price
        binding.tvNumOfExperience.text = data.experience
        binding.tvNumOfRating.text = data.rating
        binding.tvNumOfFeedback.text = data.numberOfFeedbacks.toString()
        binding.tvInfoAboutDoc.text = data.infoAboutDoctor
    }

}
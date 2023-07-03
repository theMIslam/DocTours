package com.example.doctour.presentation.ui.fragments.main.aboutdoctor

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentAboutDoctorBinding
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.extensions.showToast
import com.example.doctour.presentation.ui.state.UIState
import com.example.doctour.presentation.model.DoctorUi
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
    private var selectedList = arrayListOf<DoctorUi>()

    override fun initialize() {
        super.initialize()
        binding.rvFeedbacks.adapter = adapterFeedback
    }

    override fun initSubscribers() {
        super.initSubscribers()
        viewModel.createFav.collectUIState(
            uiState = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                viewModel.loading.postValue(false)
            }
        )
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
        binding.checkboxHeart.setOnCheckedChangeListener { checkbox, isChecked ->
            if (isChecked) {
                saveFavDoctor()
//                val data = this.arguments?.getSerializable("about") as DoctorUi
//                selectedList.add(data)
//                val bundle = Bundle()
//                bundle.putSerializable("favorite doctor", selectedList)
                showToast("Добавлено в избранные")
            } else {
                showToast("Удалено из избранных")
            }
        }
        getInfoAboutDoctor()
    }

    private fun saveFavDoctor() {
//        val data = arguments?.getSerializable("about") as DoctorUi
//        viewModel.addFavoriteDoctor(doctor = data)
    }

    private fun getInfoAboutDoctor() {
        if (arguments != null) {
            val data = this.arguments?.getSerializable("about") as DoctorUi
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

}
package com.example.doctour.presentation.ui.fragments.home.category

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentCategoryBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding, CategoryViewModel>(
    R.layout.fragment_category
) {
    override val binding: FragmentCategoryBinding by viewBinding(FragmentCategoryBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()

    override fun initListeners() {
        super.initListeners()
        binding.imgHeart.setOnClickListener {
            findNavController().navigate(R.id.favoriteDoctorsFragment)
        }
        binding.cvDoctors.setOnClickListener {
            findNavController().navigate(R.id.categoryDoctorsFragment)
        }
        binding.cvServices.setOnClickListener {
            findNavController().navigate(R.id.categoryServicesFragment)
        }
        binding.cvClinics.setOnClickListener {
            findNavController().navigate(R.id.categoryClinicFragment)
        }
    }
}
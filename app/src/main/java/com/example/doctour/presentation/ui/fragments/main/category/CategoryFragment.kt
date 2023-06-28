package com.example.doctour.presentation.ui.fragments.main.category

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding, CategoryViewModel>(
    R.layout.fragment_category
) {
    override val binding: FragmentCategoryBinding by viewBinding(FragmentCategoryBinding::bind)
    override val viewModel: CategoryViewModel by viewModels()

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
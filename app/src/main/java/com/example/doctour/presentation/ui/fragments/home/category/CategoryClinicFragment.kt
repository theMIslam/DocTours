package com.example.doctour.presentation.ui.fragments.home.category

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentCategoryClinicBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryClinicFragment :BaseFragment<FragmentCategoryClinicBinding,CategoryViewModel> (
    R.layout.fragment_category_clinic
        ){
    override val binding: FragmentCategoryClinicBinding by viewBinding(FragmentCategoryClinicBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel> ()

    override fun initListeners() {
        super.initListeners()
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}
package com.example.doctour.presentation.ui.fragments.home.category

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentCategoryDoctorsBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryDoctorsFragment : BaseFragment<FragmentCategoryDoctorsBinding,CategoryViewModel>(
    R.layout.fragment_category_doctors
) {
    override val binding: FragmentCategoryDoctorsBinding by viewBinding(FragmentCategoryDoctorsBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()
}
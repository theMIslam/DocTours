package com.example.doctour.presentation.ui.fragments.home.category

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentCategoryCityBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryCityFragment: BaseFragment<FragmentCategoryCityBinding, CategoryViewModel>(
    R.layout.fragment_category_city
) {
    override val binding: FragmentCategoryCityBinding by viewBinding(FragmentCategoryCityBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()

}
package com.example.doctour.presentation.ui.fragments.main.category.cityCategory

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentCategoryCityBinding
import com.example.doctour.presentation.extensions.showToast
import com.example.doctour.presentation.ui.fragments.main.category.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryCityFragment: BaseFragment<FragmentCategoryCityBinding, CategoryViewModel>(
    R.layout.fragment_category_city
) {
    override val binding: FragmentCategoryCityBinding by viewBinding(FragmentCategoryCityBinding::bind)
    override val viewModel: CategoryViewModel by viewModels()

    override fun initListeners() {
        super.initListeners()
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.tvBishkek.setOnClickListener {
            showToast("Bishkek")
        }
        binding.tvOsh.setOnClickListener {
            showToast("Osh")
        }
    }

}
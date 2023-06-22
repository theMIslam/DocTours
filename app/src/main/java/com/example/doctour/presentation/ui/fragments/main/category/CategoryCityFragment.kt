package com.example.doctour.presentation.ui.fragments.main.category

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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

    override fun initListeners() {
        super.initListeners()
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.tvBishkek.setOnClickListener {
            //chosen location
        }
        binding.tvOsh.setOnClickListener {
            //chosen location
        }
    }

}
package com.example.doctour.presentation.ui.fragments.main.category

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentCategoryServicesBinding
import com.example.doctour.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryServicesFragment : BaseFragment<FragmentCategoryServicesBinding, CategoryViewModel>(
    R.layout.fragment_category_services
) {
    override val binding: FragmentCategoryServicesBinding by viewBinding(FragmentCategoryServicesBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()

    override fun initListeners() {
        super.initListeners()
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}
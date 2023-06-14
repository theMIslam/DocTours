package com.example.doctour.presentation.ui.fragments.main.category

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentCategoryDoctorsBinding
import com.example.doctour.base.BaseFragment
import com.example.doctour.presentation.ui.fragments.main.category.adapter.AdapterCategoryDoctorSpec
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryDoctorsFragment : BaseFragment<FragmentCategoryDoctorsBinding, CategoryViewModel>(
    R.layout.fragment_category_doctors
) {
    override val binding: FragmentCategoryDoctorsBinding by viewBinding(FragmentCategoryDoctorsBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()
    private lateinit var  adapterCategoryDoctorSpec : AdapterCategoryDoctorSpec

    override fun initialize() {
        super.initialize()
        adapterCategoryDoctorSpec= AdapterCategoryDoctorSpec()
        binding.rvCategoryDoctor.adapter=adapterCategoryDoctorSpec
    }

    override fun initListeners() {
        super.initListeners()
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
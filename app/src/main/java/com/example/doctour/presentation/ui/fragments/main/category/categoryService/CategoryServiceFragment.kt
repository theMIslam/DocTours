package com.example.doctour.presentation.ui.fragments.main.category.categoryService

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentCategoryServiceBinding
import com.example.doctour.presentation.model.ServiceUi
import com.example.doctour.presentation.ui.fragments.main.category.clinicCategory.adapter.CategoryClinicAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryServiceFragment :
    BaseFragment<FragmentCategoryServiceBinding, CategoryServicesViewModel>(R.layout.fragment_category_service) {

    override val binding: FragmentCategoryServiceBinding by viewBinding(
        FragmentCategoryServiceBinding::bind
    )
    override val viewModel: CategoryServicesViewModel by viewModels()
    private val adapter = CategoryClinicAdapter()

    override fun initListeners() {
        super.initListeners()
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
        getInfoAboutClinics()
    }

    private fun getInfoAboutClinics() {
        if (arguments != null){
            val result: ServiceUi = arguments?.getSerializable("service") as ServiceUi
            binding.tvServices.text = result.name
            viewModel.x(result.name.toString())
            viewModel.getServiceOfDoctors()
            binding.rvServices.adapter = adapter
        }
    }
}
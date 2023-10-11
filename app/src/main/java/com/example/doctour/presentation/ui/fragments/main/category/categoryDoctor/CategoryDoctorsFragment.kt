package com.example.doctour.presentation.ui.fragments.main.category.categoryDoctor

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentCategoryDoctorsBinding
import com.example.doctour.presentation.module.showToast
import com.example.doctour.presentation.model.speciality.SpecialtyUI
import com.example.doctour.presentation.ui.adapters.category.categoryDoctor.CategoryDoctorSpecAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryDoctorsFragment : BaseFragment<FragmentCategoryDoctorsBinding, CategoryDoctorsViewModel>(
    R.layout.fragment_category_doctors
) {
    override val binding: FragmentCategoryDoctorsBinding by viewBinding(
        FragmentCategoryDoctorsBinding::bind
    )
    override val viewModel: CategoryDoctorsViewModel by viewModels()
    private lateinit var adapterCategoryDoctorSpec: CategoryDoctorSpecAdapter

    override fun initialize() {
        super.initialize()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        adapterCategoryDoctorSpec = CategoryDoctorSpecAdapter(this::onItemClick)
        binding.rvCategoryDoctor.adapter = adapterCategoryDoctorSpec
        binding.rvCategoryDoctor.layoutManager=LinearLayoutManager(requireContext())

        adapterCategoryDoctorSpec.addLoadStateListener {loadState ->
            binding.rvCategoryDoctor.isVisible= loadState.refresh is  LoadState.NotLoading
            binding.progressBar.isVisible= loadState.refresh is  LoadState.Loading
        }
    }

    override fun initRequest() {
        super.initRequest()
        getSpecialityDoctors()
    }

    private fun getSpecialityDoctors() {
        viewModel.getSpecialityOfDoctors().collectPaging {
            adapterCategoryDoctorSpec.submitData(it)
        }
    }

    private fun onItemClick(specialityUi: SpecialtyUI) {
        showToast("Click CLick")
    }

    override fun initListeners() {
        super.initListeners()
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
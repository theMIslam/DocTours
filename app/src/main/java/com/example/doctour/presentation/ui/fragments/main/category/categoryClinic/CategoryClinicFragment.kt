package com.example.doctour.presentation.ui.fragments.main.category.categoryClinic

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentCategoryClinicBinding
import com.example.doctour.presentation.ui.fragments.main.category.categoryClinic.adapter.CategoryClinicAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryClinicFragment : BaseFragment<FragmentCategoryClinicBinding,CategoryClinicViewModel >(
    R.layout.fragment_category_clinic
){
    override val binding: FragmentCategoryClinicBinding by viewBinding(FragmentCategoryClinicBinding::bind)
    override val viewModel: CategoryClinicViewModel by viewModels()
    private val adapterCategoryClinic= CategoryClinicAdapter()

    override fun initListeners() {
        super.initListeners()
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun initialize() {
        super.initialize()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.rvClinics.layoutManager = LinearLayoutManager(requireContext())
        binding.rvClinics.adapter=adapterCategoryClinic
        adapterCategoryClinic.addLoadStateListener { loadStates ->
            binding.rvClinics.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadStates.refresh is LoadState.Loading
        }
    }

    override fun initRequest() {
        super.initRequest()
        getClinics()
    }

    private fun getClinics() {
        viewModel.getClinic().collectPaging {
            adapterCategoryClinic.submitData(it)
        }
    }

}
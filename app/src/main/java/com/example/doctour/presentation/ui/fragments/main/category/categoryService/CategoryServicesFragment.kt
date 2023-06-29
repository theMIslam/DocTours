package com.example.doctour.presentation.ui.fragments.main.category.categoryService

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentCategoryServicesBinding
import com.example.doctour.presentation.ui.fragments.main.category.categoryService.adapter.CategoryServicesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
@AndroidEntryPoint
class CategoryServicesFragment : BaseFragment<FragmentCategoryServicesBinding, CategoryServicesViewModel>(
    R.layout.fragment_category_services
) {
    override val binding: FragmentCategoryServicesBinding by viewBinding(FragmentCategoryServicesBinding::bind)
    override val viewModel: CategoryServicesViewModel by viewModels()
    private val adapterCategoryServices= CategoryServicesAdapter()

    override fun initListeners() {
        super.initListeners()
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun initRequest() {
        super.initRequest()
        adapterCategoryServices.addLoadStateListener { loadStates ->
            binding.rvServices.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadStates.refresh is LoadState.Loading
        }
        getServices()
    }

    private fun getServices() {
        //viewModel.getServiceOfDoctors().collectPaging {
        // adapterCategoryServices.submitData(it)
        //}

        val pagingData: PagingData<String> = stringList.toPagingData()

        viewLifecycleOwner.lifecycleScope.launch {
            adapterCategoryServices.submitData(pagingData)
        }
    }

    val stringList: List<String> = getYourStringList()

    private fun getYourStringList(): List<String> {
        return listOf("Узи", "Узи", "Узи")
    }

    fun List<String>.toPagingData(): Flow<PagingData<String>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { StringPagingSource(this) }
        ).flow
    }


    override fun initialize() {
        super.initialize()
        binding.rvServices.adapter = adapterCategoryServices
        binding.rvServices.layoutManager = LinearLayoutManager(requireContext())
    }

}
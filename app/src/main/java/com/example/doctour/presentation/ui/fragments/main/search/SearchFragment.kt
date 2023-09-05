package com.example.doctour.presentation.ui.fragments.main.search

import android.annotation.SuppressLint
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentSearchBinding
import com.example.doctour.presentation.model.doctour.DoctorUI
import com.example.doctour.presentation.ui.adapter.search.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("ClickableViewAccessibility")
class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewModel>
        (R.layout.fragment_search) {

    override val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)
    override val viewModel: SearchViewModel by viewModels()
    private lateinit var myAdapter: SearchAdapter

    override fun initListeners() {
        super.initListeners()
        onClickListeners()
    }

    override fun initialize() {
        super.initialize()
        binding.rv.layoutManager = LinearLayoutManager(context)
        myAdapter = SearchAdapter(this::onItemClick)
        binding.rv.adapter = myAdapter

        myAdapter.addLoadStateListener { loadStates ->
            binding.rv.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadStates.refresh is LoadState.Loading
            viewModel.setItemAmount(myAdapter.itemCount)
        }

        viewModel.doc.collectPaging {
            myAdapter.submitData(it)
        }
        viewModel.count.observe(viewLifecycleOwner){count ->
            binding.tvFound.text = "Найдено ${count.toString()}"
        }
    }

    private fun onItemClick(doctorUi: DoctorUI) {
        findNavController().navigate(R.id.aboutDoctorFragment, bundleOf( "about" to doctorUi))
    }

    private fun onClickListeners() {
        binding.searview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query!=null){
                    binding.rv.scrollToPosition(0)
                    viewModel.searchBy(query)
                    binding.searview.clearFocus()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText!=null){
                    binding.rv.scrollToPosition(0)
                    viewModel.searchBy(newText)
                }
                return false
            }
        })

        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
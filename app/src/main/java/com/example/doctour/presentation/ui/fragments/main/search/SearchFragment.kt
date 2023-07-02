package com.example.doctour.presentation.ui.fragments.main.search

import android.annotation.SuppressLint
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentSearchBinding
import com.example.doctour.presentation.model.DoctorUi
import com.example.doctour.presentation.ui.fragments.main.search.adapter.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("ClickableViewAccessibility")
class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewModel>
        (R.layout.fragment_search) {

    private var myAdapter: SearchAdapter? = null
    private var users = ArrayList<DoctorUi>()

    override val binding: FragmentSearchBinding by  viewBinding(FragmentSearchBinding::bind)
    override val viewModel: SearchViewModel by viewModels()

    override fun initListeners() {
        super.initListeners()
        myAdapter = SearchAdapter(users,this::onItemClick)
        binding.rv.adapter = myAdapter
        onClickListeners()
    }

    private fun onItemClick(doctorUi: DoctorUi) {
      findNavController().navigate(R.id.aboutDoctorFragment)
    }

    private fun onClickListeners() {
        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.searview.setOnQueryTextListener(object :OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //запрос на сервер поиск по серверу
                return true
            }
        })
    }
}
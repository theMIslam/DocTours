package com.example.doctour.presentation.ui.fragments.home.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentHomeBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.extensions.navigateSafely
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeDoctorSpecs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()
    private val adapterHome = AdapterHomeDoctorSpecs(
            this::onClick
        )

    override fun initialize() {
        binding.rvDoctorsSpecs.adapter = adapterHome

        binding.tvBestDoctor.setOnClickListener {
            findNavController().navigateSafely(R.id.homeFragment2)
        }
        binding.imgAvatar.setOnClickListener {

        }

    }
    fun onClick(){
        findNavController().navigateSafely(R.id.homeFragment2)
    }
}


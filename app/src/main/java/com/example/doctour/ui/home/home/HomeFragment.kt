package com.example.doctour.ui.home.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentHomeBinding
import com.example.doctour.presentation.core.base.BaseFragment
import com.example.doctour.presentation.core.extension.navigateSafely
import com.example.doctour.ui.home.adapter.AdapterHomeDoctorSpecs

class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()
    private val adapterHome = AdapterHomeDoctorSpecs(this::onClick)

    override fun initialize() {
        binding.rvDoctorsSpecs.adapter = adapterHome

        binding.tvBestDoctor.setOnClickListener {
            findNavController().navigateSafely(R.id.homeFragment2)
        }

        binding.imgNotification.setOnClickListener {
            findNavController().navigateSafely(R.id.homeFragment2)

        }
        binding.imgHeart.setOnClickListener {
            findNavController().navigateSafely(R.id.homeFragment2)
        }

    }
    fun onClick(){
        findNavController().navigateSafely(R.id.homeFragment2)
    }
}


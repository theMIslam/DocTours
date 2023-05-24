package com.example.doctour.ui.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.core.base.BaseFragment
import com.example.doctour.core.extension.navigateSafely
import com.example.doctour.databinding.FragmentHomeBinding
import com.example.doctour.ui.home.adapter.home_adapter.AdapterHomeDoctorSpecs
class HomeFragment() : BaseFragment<FragmentHomeBinding, ViewModel>(R.layout.fragment_home) {
    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<ViewModel>()
    private val adapterHome = AdapterHomeDoctorSpecs(this::onClick)

    override fun initialize() {
        binding.rvDoctorsSpecs.adapter = adapterHome

        binding.tvBestDoctor.setOnClickListener {
            findNavController().navigateSafely(R.id.action_homeFragment2_to_topDoctorsFragment)
        }

        binding.imgNotification.setOnClickListener {
            findNavController().navigateSafely(R.id.action_homeFragment2_to_notificationFragment)

        }
        binding.imgHeart.setOnClickListener {
            findNavController().navigateSafely(R.id.action_homeFragment2_to_favoriteDoctorsFragment)
        }

    }
     fun onClick(){
        findNavController().navigateSafely(R.id.action_homeFragment2_to_topDoctorsFragment)
    }
}

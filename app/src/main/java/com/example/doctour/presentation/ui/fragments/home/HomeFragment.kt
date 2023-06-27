package com.example.doctour.presentation.ui.fragments.home

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentHomeBinding
import com.example.doctour.presentation.extensions.navigateSafely
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeClinic
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeDoctorSpecs
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeInfoDoctor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home),
    Parcelable {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()
    private val adapterHome = AdapterHomeDoctorSpecs(this::specsClick)
    private val adapterHomeClinic = AdapterHomeClinic(this::clinicClick)
    private val adapterHomeInfoDoctor= AdapterHomeInfoDoctor(this::infoDoctorClick)

    constructor(parcel: Parcel) : this() {
    }

    override fun initListeners() {
        super.initListeners()
        binding.ivHeart.setOnClickListener {
            findNavController().navigate(R.id.favoriteDoctorsFragment)
        }
        binding.ivSearch.setOnClickListener {
            findNavController().navigate(R.id.searchFragment2)
        }
        binding.tvCountry.setOnClickListener {
            findNavController().navigate(R.id.categoryCityFragment)
        }

    }
    override fun initialize() {
        binding.rvDoctorsSpecs.adapter = adapterHome
        binding.rvClinic.adapter=adapterHomeClinic
        binding.rvDoctorsInfo.adapter=adapterHomeInfoDoctor
    }
   private fun specsClick(){
        findNavController().navigateSafely(R.id.homeFragment)
    }
    private fun infoDoctorClick(){
        findNavController().navigate(R.id.aboutDoctorFragment)
    }
    private fun clinicClick(){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HomeFragment> {
        override fun createFromParcel(parcel: Parcel): HomeFragment {
            return HomeFragment(parcel)
        }

        override fun newArray(size: Int): Array<HomeFragment?> {
            return arrayOfNulls(size)
        }
    }
}


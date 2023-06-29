package com.example.doctour.presentation.ui.fragments.home

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentHomeBinding
import com.example.doctour.presentation.extensions.navigateSafely
import com.example.doctour.presentation.model.DoctorUi
import com.example.doctour.presentation.ui.fragments.home.adapter.HomeDoctorSpecsAdapter
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeInfoDoctor
import com.example.doctour.presentation.ui.fragments.home.adapter.HomeClinicAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home){

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel:HomeViewModel by viewModels()
    private val adapterHome = HomeDoctorSpecsAdapter(this::specsClick)
    private val adapterHomeClinic = HomeClinicAdapter(this::clinicClick)
    private val adapterHomeInfoDoctor= AdapterHomeInfoDoctor()

    private fun setUpHomeInFoRecycler() {
        with(binding){
            rvDoctorsInfo.layoutManager=LinearLayoutManager(context)
            rvClinic.layoutManager=LinearLayoutManager(context)
            rvDoctorsSpecs.layoutManager=LinearLayoutManager(context)
            rvDoctorsInfo.adapter=adapterHomeInfoDoctor
            rvDoctorsSpecs.adapter=adapterHome
            rvClinic.adapter=adapterHomeClinic }
        adapterHomeInfoDoctor.addLoadStateListener {loadState ->
            binding.rvDoctorsInfo.isVisible= loadState.refresh is  LoadState.NotLoading
            binding.progressBar.isVisible= loadState.refresh is  LoadState.NotLoading
        }
        fetchDoctorInfo()

    }

    override fun initRequest() {
        super.initRequest()
    }

    private fun fetchDoctorInfo() {
        viewModel.getALlDoctors().collectPaging {
            adapterHomeInfoDoctor.submitData(it)
        }
    }

    override fun initialize() {
        super.initialize()
        setUpHomeInFoRecycler()
        binding.tvName.hint = "ФИО"
        getSharedData()

    }
    private fun getSharedData() {
        val pref = activity?.getSharedPreferences("preferences_profile", Context.MODE_PRIVATE)
        val id = pref?.getString("fio","")
        binding.tvName.text = id
    }
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
   private fun specsClick(){
        findNavController().navigateSafely(R.id.homeFragment)
    }
    private fun infoDoctorClick(doctorUi: DoctorUi){
        findNavController().navigate(R.id.aboutDoctorFragment)
    }
    private fun clinicClick(){

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


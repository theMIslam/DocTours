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
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeClinic
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeDoctorSpecs
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeInfoDoctor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home),
    Parcelable {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel:HomeViewModel by viewModels()
    private val adapterHome = AdapterHomeDoctorSpecs(this::specsClick)
    private val adapterHomeClinic = AdapterHomeClinic(this::clinicClick)
    private val adapterHomeInfoDoctor= AdapterHomeInfoDoctor(this::infoDoctorClick)

    private fun setUpHomeInFoRecycler() = with(binding){
        rvDoctorsInfo.layoutManager=LinearLayoutManager(requireContext())
        rvDoctorsInfo.adapter=adapterHomeInfoDoctor
        adapterHomeInfoDoctor.addLoadStateListener {loadState ->
            rvDoctorsInfo.isVisible= loadState.refresh is  LoadState.NotLoading
            progressBar.isVisible= loadState.refresh is  LoadState.NotLoading
        }
    }

    override fun initRequest() {
        super.initRequest()
        setUpHomeInFoRecycler()
        fetchDoctorInfo()
    }

    private fun fetchDoctorInfo() {
        viewModel.getALlDoctors().collectPaging {
            adapterHomeInfoDoctor.submitData(it)
        }
    }

    override fun initialize() {
        super.initialize()
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


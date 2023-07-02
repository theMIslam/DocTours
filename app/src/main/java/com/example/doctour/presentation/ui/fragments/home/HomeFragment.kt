package com.example.doctour.presentation.ui.fragments.home

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.core.os.bundleOf
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
import com.example.doctour.model.DoctorUi
import com.example.doctour.presentation.extensions.showToast
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeClinic
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeDoctorSpecs
import com.example.doctour.presentation.ui.fragments.home.adapter.AdapterHomeInfoDoctor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home),
    AdapterHomeInfoDoctor.ClickListener {

    override fun onClick(doctorUi: DoctorUi) {
        findNavController().navigate(R.id.aboutDoctorFragment, bundleOf(
                "about" to doctorUi
            ))
    }

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()

    private val adapterHomeDoctorSpecs = AdapterHomeDoctorSpecs(this::onSpecsClick)
    private val adapterHomeClinic = AdapterHomeClinic(this::onClinicClick)
    private val adapterHomeInfoDoctor = AdapterHomeInfoDoctor(this)

    private fun setUpHomeInFoRecycler() {
        with(binding) {
            rvDoctorsSpecs.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvDoctorsSpecs.adapter = adapterHomeDoctorSpecs
            rvClinic.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvClinic.adapter = adapterHomeClinic
            rvDoctorsInfo.layoutManager = LinearLayoutManager(context)
            rvDoctorsInfo.adapter = adapterHomeInfoDoctor
        }
        adapterHomeDoctorSpecs.addLoadStateListener { loadState ->
            binding.rvDoctorsSpecs.isVisible = loadState.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadState.refresh is LoadState.Loading
        }
        adapterHomeClinic.addLoadStateListener { loadState ->
            binding.rvClinic.isVisible = loadState.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadState.refresh is LoadState.Loading
        }
        adapterHomeInfoDoctor.addLoadStateListener { loadState ->
            binding.rvDoctorsInfo.isVisible = loadState.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadState.refresh is LoadState.Loading
        }
    }

    private fun onDoctorInfoClick(doctorUi: DoctorUi) {
        findNavController().navigate(
            R.id.aboutDoctorFragment, bundleOf(
                "about" to doctorUi
            )
        )
    }

    override fun initRequest() {
        super.initRequest()
        fetchDoctorInfo()
    }

    private fun fetchDoctorInfo() {
        viewModel.getTheBestDoctorSpeciality().collectPaging {
            adapterHomeDoctorSpecs.submitData(it)
        }
        viewModel.getTheBestClinics().collectPaging {
            adapterHomeClinic.submitData(it)
        }
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
        val id = pref?.getString("fio", "")
        binding.tvName.text = id
    }

    constructor(parcel: Parcel) : this() {
    }

    override fun initListeners() {
        super.initListeners()
        binding.checkboxHeart.setOnClickListener {
            findNavController().navigate(R.id.favoriteDoctorsFragment)
        }
        binding.ivSearch.setOnClickListener {
            findNavController().navigate(R.id.searchFragment2)
        }
        binding.tvCountry.setOnClickListener {
            findNavController().navigate(R.id.categoryCityFragment)
        }

    }

    private fun onSpecsClick() {
        showToast("Speciality Click")
    }

    private fun onClinicClick() {
        showToast("Clinic Click")
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


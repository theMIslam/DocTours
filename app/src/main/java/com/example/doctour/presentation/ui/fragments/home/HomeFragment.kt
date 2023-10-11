package com.example.doctour.presentation.ui.fragments.home

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentHomeBinding
import com.example.doctour.presentation.module.showToast
import com.example.doctour.presentation.model.doctour.DoctorUI
import com.example.doctour.presentation.ui.fragments.authAndReg.auth.TokenViewModel
import com.example.doctour.presentation.ui.adapters.home.homeClinic.HomeClinicAdapter
import com.example.doctour.presentation.ui.adapters.home.homeDoctor.HomeDoctorSpecsAdapter
import com.example.doctour.presentation.ui.adapters.home.homeInfo.HomeInfoDoctorAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home),
    HomeInfoDoctorAdapter.ClickListener {

    override fun onClick(doctorUi: DoctorUI) {
        findNavController().navigate(R.id.aboutDoctorFragment, bundleOf(
                "about" to doctorUi
            ))
    }

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val tokenViewModel : TokenViewModel by activityViewModels()
    private var token :String ?=null

    private val adapterHomeDoctorSpecs = HomeDoctorSpecsAdapter(this::onSpecsClick)
    private val adapterHomeClinic = HomeClinicAdapter(this::onClinicClick)
    private val adapterHomeInfoDoctor = HomeInfoDoctorAdapter(this)
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

    override fun initSubscribers() {
        super.initSubscribers()
        tokenViewModel.token.observe(viewLifecycleOwner){token ->
            this.token = token
            if (token == null){
                findNavController().navigate(R.id.SignInAndSignUpFragment)
                //showToast("Token is Null")
            }else{
                fetchDoctorInfo()
            }
        }
    }
    private fun onDoctorInfoClick(doctorUi: DoctorUI) {
        findNavController().navigate(
            R.id.aboutDoctorFragment, bundleOf(
                "about" to doctorUi
            )
        )
    }

    override fun initRequest() {
        super.initRequest()

        viewModel.doctorUIState.collectUiStateBema(
            onSuccess = {
                binding.progressBar.isVisible = false
             showToast("Successfully")
            },
            onError = {
                binding.progressBar.isVisible = true
                showToast(it)
            }
        )

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
        findNavController().navigate(R.id.aboutDoctorFragment)
    }

    private fun onClinicClick() {
        showToast("Clinic")
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


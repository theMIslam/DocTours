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
import com.example.doctour.presentation.ui.fragments.home.model.DoctorModel
import com.example.doctour.presentation.ui.fragments.home.model.HomeModel
import com.example.doctour.presentation.ui.fragments.main.category.observer.DataChangeListener
import com.example.doctour.presentation.ui.fragments.main.category.observer.TextUpdate
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home),
    Parcelable, DataChangeListener {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()
    private val adapterHome = AdapterHomeDoctorSpecs(this::specsClick)
    private val data = mutableListOf<HomeModel>()
    private val doctors = mutableListOf<DoctorModel>()
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
        super.initialize()
        adapterHome()
        adapterHomeClinic()
        adapterHomeInfoDoctor()
    }
    private fun adapterHome() {
        binding.rvDoctorsSpecs.adapter = adapterHome
        val item1 = HomeModel(getString(R.string.Therapist), R.drawable.ic_people)
        val item2 = HomeModel(getString(R.string.Therapist), R.drawable.ic_people)
        val item3 = HomeModel(getString(R.string.Therapist), R.drawable.ic_people)
        val item4 = HomeModel(getString(R.string.Therapist), R.drawable.ic_people)
        data.add(item1)
        data.add(item2)
        data.add(item3)
        data.add(item4)
        adapterHome.submitList(data)
    }

    private fun adapterHomeClinic() {
        binding.rvClinic.adapter=adapterHomeClinic
        val item1 = HomeModel(getString(R.string.on_clinic), R.drawable.on_clinik)
        val item2 = HomeModel(getString(R.string.on_clinic), R.drawable.on_clinik)
        val item3 = HomeModel(getString(R.string.on_clinic), R.drawable.on_clinik)
        val item4 = HomeModel(getString(R.string.on_clinic), R.drawable.on_clinik)
        data.add(item1)
        data.add(item2)
        data.add(item3)
        data.add(item4)
        adapterHomeClinic.submitList(data)
    }

    private fun adapterHomeInfoDoctor() {
        binding.rvDoctorsInfo.adapter=adapterHomeInfoDoctor
        val item1 = DoctorModel(getString(R.string.Name), getString(R.string.workexperience),
        getString(R.string.xirurg), getString(R.string.on_clinic), R.drawable.ic_star,
        getString(R.string.score), getString(R.string.feedback_32), R.drawable.layer_list_location,
        getString(R.string.bishkek), getString(R.string.sum), R.drawable.ic_som)
        val item2 = DoctorModel(getString(R.string.Name), getString(R.string.workexperience),
            getString(R.string.xirurg), getString(R.string.on_clinic), R.drawable.ic_star,
            getString(R.string.score), getString(R.string.feedback_32), R.drawable.layer_list_location,
            getString(R.string.bishkek), getString(R.string.sum), R.drawable.ic_som)

        doctors.add(item1)
        doctors.add(item2)

        adapterHomeInfoDoctor.submitList(doctors)
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onTextUpdate(event: TextUpdate) {
        binding.tvCountry.text = event.newText
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun updateText(newText: String) {
        binding.tvCountry.text = newText
    }
}


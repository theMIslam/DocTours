package com.example.doctour.presentation.ui.fragments.booking


import android.view.View
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentBookingToDoctorSecondBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.utils.showToast

class BookingToDoctorSecondFragment :BaseFragment<FragmentBookingToDoctorSecondBinding,BookingToDoctorViewModel>(
    R.layout.fragment_booking_to_doctor_second
){

    override val binding: FragmentBookingToDoctorSecondBinding by viewBinding(FragmentBookingToDoctorSecondBinding::bind)
    override val viewModel: BookingToDoctorViewModel by viewModels<BookingToDoctorViewModel>()
    private val isSuccess :Boolean = false

    override fun initListeners() {
        super.initListeners()
        setDropDownMenu()
        onClick()
    }

    private fun onClick() {
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnMakeAnAppointment.setOnClickListener {
                binding.includeSuccessBooking.root.visibility = View.VISIBLE
        }
        binding.includeSuccessBooking.btnDone.setOnClickListener {
            //action
            showToast("Success_appoiment")
        }
        binding.includeFailedBooking.btnDone.setOnClickListener {
            //action
            showToast("Failed_appoiment")
        }

    }

    private fun setDropDownMenu() {
        val gender = arrayOf("Женский", "Мужской")
        val arrayAdapter = ArrayAdapter(requireActivity(), R.layout.item_dropdown, gender)
        binding.autvGender.setAdapter(arrayAdapter)
    }
}
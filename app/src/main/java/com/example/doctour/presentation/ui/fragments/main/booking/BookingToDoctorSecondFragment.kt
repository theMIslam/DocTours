package com.example.doctour.presentation.ui.fragments.main.booking


import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentBookingToDoctorSecondBinding
import com.example.doctour.presentation.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookingToDoctorSecondFragment :
    BaseFragment<FragmentBookingToDoctorSecondBinding, BookingToDoctorViewModel>(
    R.layout.fragment_booking_to_doctor_second
){

    override val binding: FragmentBookingToDoctorSecondBinding by viewBinding(FragmentBookingToDoctorSecondBinding::bind)
    override val viewModel: BookingToDoctorViewModel by viewModels()

    override fun initListeners() {
        super.initListeners()
        onClick()
    }

    private fun onClick() {
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnMakeAnAppointment.setOnClickListener {
            val phoneNumber = "+996704848277"
            val message = "Привет, я хотел бы записаться на приём!"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber&text=$message")

            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            } else {
                showToast("WhatsApp не установлен на вашем устройстве")
            }
            binding.includeSuccessBooking.root.visibility = View.VISIBLE
        }


//        binding.btnMakeAnAppointment.setOnClickListener {
//            // TODO: make appoiment
//
//
//                binding.includeSuccessBooking.root.visibility = View.VISIBLE
//        }
        binding.includeSuccessBooking.btnDone.setOnClickListener {
            // TODO: action
            showToast("Success_appoiment")
        }
        binding.includeFailedBooking.btnDone.setOnClickListener {
            // TODO: action
            showToast("Failed_appoiment")
        }

    }
}
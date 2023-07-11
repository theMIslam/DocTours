package com.example.doctour.presentation.ui.fragments.main.booking


import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentBookingToDoctorSecondBinding
import com.example.doctour.presentation.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLEncoder

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
            val fio = binding.etFio.text.toString()
            val userPhoneNumber = binding.etNumberOfPhone.text.toString()
            val userDateOfBirthday = binding.etDateOfBirthday.text.toString()
            var gender = ""
            if (binding.btnFemale.isChecked) gender="Женский"
            if (binding.btnMale.isChecked) gender = "Мужской"

             val message = "Здравствуйте," +
                     "Я хотел(а) бы записаться к Вам .\n" +
                     "Немного информации обо мне⬇️\n" +
                     "Фио: ${fio}\n" +
                     "Номер телефона: ${userPhoneNumber}\n" +
                     "Дата рождения: ${userDateOfBirthday}\n" +
                     "Пол: ${gender}"

            goToWhatsApp(message = message,"+996702111582")
            goToWhatsAppBusiness(message = message,"+996704848277")

        }
    }

    private fun goToWhatsApp(message:String,phoneNumber:String) {
        try {
            val  packageManager:PackageManager = requireActivity().packageManager
            val  i = Intent(Intent.ACTION_VIEW)
            val url = "https://api.whatsapp.com/send?phone="+ phoneNumber +"&text=" + URLEncoder.encode(message, "UTF-8")
            i.setPackage("com.whatsapp")
            i.setData(Uri.parse(url))
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i)
            }else {
                showToast("WhatsApp Error")
            }
        }catch (e:Exception){
            Log.e("WhatsApp Error", e.toString())
        }
    }

    private fun goToWhatsAppBusiness(message: String, phoneNumber: String) {
        try {
            val packageManager: PackageManager = requireActivity().packageManager
            val i = Intent(Intent.ACTION_VIEW)
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=${URLEncoder.encode(message, "UTF-8")}"
            i.setPackage("com.whatsapp.w4b") // Package name for WhatsApp Business
            i.setData(Uri.parse(url))
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i)
            } else {
                showToast("WhatsApp Business Error")
            }
        } catch (e: Exception) {
            Log.e("WhatsApp Business Error", e.toString())
        }
    }

}
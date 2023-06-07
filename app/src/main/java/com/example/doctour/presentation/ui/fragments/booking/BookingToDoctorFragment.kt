package com.example.doctour.presentation.ui.fragments.booking

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentBookingToDoctorBinding
import com.example.doctour.presentation.base.BaseFragment
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class BookingToDoctorFragment : BaseFragment<FragmentBookingToDoctorBinding,BookingToDoctorViewModel>(
    R.layout.fragment_booking_to_doctor
){
    override val binding: FragmentBookingToDoctorBinding by viewBinding(FragmentBookingToDoctorBinding::bind)
    override val viewModel: BookingToDoctorViewModel by viewModels<BookingToDoctorViewModel>()
    override fun initListeners() {
        super.initListeners()
        setupCalendar()
        setupChipTimes()
        setupNextButton()
        click()
    }

    private fun click() {
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.bookingToDoctorSecondFragment)
        }
    }

    private fun setupCalendar() {
        binding.calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance().apply {
                set(Calendar.YEAR, year)
                set(Calendar.MONTH, month)
                set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }

            // Do something with the selected date
            // For example, you can format the date and display it in a TextView
            val formattedDate =
                SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(selectedDate.time)
            binding.tvData.text = formattedDate
        }
    }

    private fun setupChipTimes() {
        val chipTimes: Array<Chip> = arrayOf(
            binding.chipTime1,
            binding.chipTime2,
            binding.chipTime3,
            binding.chipTime4,
            binding.chipTime5,
            binding.chipTime6,
            binding.chipTime7,
            binding.chipTime8,
        )

        for (chip in chipTimes) {
            chip.setOnClickListener {
                // Clear the selection state of all chips
                for (otherChip in chipTimes) {
                    otherChip.isChecked = false
                }
                // Set the current chip as selected
                chip.isChecked = true

                // Do something with the selected time slot
            }
        }
    }

    private fun setupNextButton() {
        binding.btnNext.setOnClickListener {
            // Perform the next step in the booking process
        }
    }
}

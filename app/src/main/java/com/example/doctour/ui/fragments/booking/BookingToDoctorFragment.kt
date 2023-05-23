package com.example.doctour.ui.fragments.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doctour.databinding.FragmentBookingToDoctorBinding
import com.google.android.material.chip.Chip
import java.text.SimpleDateFormat
import java.util.*

class BookingToDoctorFragment : Fragment() {
    private lateinit var binding: FragmentBookingToDoctorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookingToDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCalendar()
        setupChipTimes()
        setupNextButton()
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

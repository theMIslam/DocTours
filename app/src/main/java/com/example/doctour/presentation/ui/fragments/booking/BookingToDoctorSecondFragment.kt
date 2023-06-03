package com.example.doctour.presentation.ui.fragments.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.doctour.R
import com.example.doctour.databinding.FragmentBookingToDoctorSecondBinding

class BookingToDoctorSecondFragment : Fragment() {

    private lateinit var binding: FragmentBookingToDoctorSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookingToDoctorSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDropDownMenu()
    }

    private fun setDropDownMenu() {
        val gender = arrayOf("Женский", "Мужской")
        val arrayAdapter = ArrayAdapter(requireActivity(), R.layout.item_dropdown, gender)
        binding.autvGender.setAdapter(arrayAdapter)
    }
}
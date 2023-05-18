package com.example.doctour.ui.fragments.aboutdoctor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doctour.databinding.FragmentAboutDoctorBinding

class AboutDoctorFragment : Fragment() {

    private lateinit var binding: FragmentAboutDoctorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutDoctorBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }
}
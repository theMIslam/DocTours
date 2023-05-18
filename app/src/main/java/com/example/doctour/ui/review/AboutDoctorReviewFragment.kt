package com.example.doctour.ui.review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doctour.databinding.FragmentAboutDoctorReviewBinding

class AboutDoctorReviewFragment : Fragment() {

    private lateinit var binding: FragmentAboutDoctorReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentAboutDoctorReviewBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }
}
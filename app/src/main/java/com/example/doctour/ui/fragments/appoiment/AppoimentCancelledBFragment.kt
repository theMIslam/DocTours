package com.example.doctour.ui.fragments.appoiment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentCancelledBBinding

class AppoimentCancelledBFragment : Fragment() {

    private lateinit var binding : FragmentAppoimentCancelledBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppoimentCancelledBBinding.inflate(layoutInflater)
        return binding.root
    }
}
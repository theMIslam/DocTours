package com.example.doctour.presentation.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.doctour.R
import com.example.doctour.databinding.FragmentCreatePinBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class CreatePinFragment : Fragment() {

    private lateinit var binding : FragmentCreatePinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreatePinBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checking()
    }

    private fun checking() {
        if (binding.etOne.text.isNotEmpty()) {
            findNavController().navigate(R.id.successPasswordFragment)
        }
    }
}
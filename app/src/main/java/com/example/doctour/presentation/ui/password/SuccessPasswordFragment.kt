package com.example.doctour.presentation.ui.password

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.doctour.databinding.FragmentSuccessPasswordBinding

class SuccessPasswordFragment : Fragment() {

    private lateinit var binding : FragmentSuccessPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuccessPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickers()
    }

    private fun clickers() {
        binding.btnDone.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
package com.example.doctour.presentation.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.doctour.R
import com.example.doctour.databinding.FragmentProfileFillBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class FillProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileFillBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileFillBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checking()
    }

    private fun checking() {
        //отправка данных на сервер
        if (binding.etFio.text.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.fio_), Toast.LENGTH_SHORT).show()
        }
    }
}
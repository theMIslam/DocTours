package com.example.doctour.presentation.ui.password

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.doctour.R
import com.example.doctour.databinding.FragmentChangePasswordBinding

class ChangePasswordFragment : Fragment() {

    private lateinit var binding: FragmentChangePasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangePasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickers()
    }

    private fun clickers() {
        with(binding) {
            btnNext.setOnClickListener {
                if (etCurrentPassword.text.isEmpty() || etNewPassword.text.isEmpty() || etRepeatNewPassword.text.isEmpty()) {
                    Toast.makeText(requireContext(), getString(R.string.line_), Toast.LENGTH_SHORT).show()
                }
                if (etCurrentPassword.text != etNewPassword.text) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.change_password),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                when (etNewPassword.text) {
                    etRepeatNewPassword -> {
                        //change password in server
                    }
                }
            }
        }
    }
}
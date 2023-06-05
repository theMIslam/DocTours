package com.example.doctour.presentation.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.doctour.R
import com.example.doctour.databinding.FragmentMoreBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBottomSheet()
        clickers()
    }

    private fun clickers() {
        with(binding) {
            btnProfile.setOnClickListener {
                findNavController().navigate(R.id.fillProfileFragment)
            }
            btnPassword.setOnClickListener {
                findNavController().navigate(R.id.changePasswordFragment)
            }
        }
    }

    private fun setBottomSheet() {
        binding.btnExit.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.exit_bottom_sheet, null)
            val dialog = BottomSheetDialog(requireActivity())
            dialog.setContentView(view)
            dialog.show()
        }
        binding.btnLanguage.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.bottom_language, null)
            val dialog = BottomSheetDialog(requireActivity())
            dialog.setContentView(view)
            dialog.show()
        }
    }
}
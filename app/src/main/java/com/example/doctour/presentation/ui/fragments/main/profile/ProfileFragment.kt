package com.example.doctour.presentation.ui.fragments.main.profile

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentProfileBinding
import com.example.doctour.presentation.ui.fragments.authAndReg.signIn.SignInViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class ProfileFragment : BaseFragment<FragmentProfileBinding, SignInViewModel>(
    R.layout.fragment_profile
) {

    override val binding: FragmentProfileBinding by viewBinding(FragmentProfileBinding::bind)
    override val viewModel: SignInViewModel by viewModels<SignInViewModel>()

    override fun initListeners() {
        super.initListeners()
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
    }
}
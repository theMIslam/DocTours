package com.example.doctour.presentation.ui.fragments.main.profile

import android.content.Context
import android.view.View
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentProfileBinding
import com.example.doctour.di.UserPreferences
import com.example.doctour.presentation.extensions.showToast
import com.example.doctour.presentation.ui.fragments.authAndReg.signIn.SignInViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class ProfileFragment : BaseFragment<FragmentProfileBinding, SignInViewModel>(
    R.layout.fragment_profile
) {

    override val binding: FragmentProfileBinding by viewBinding(FragmentProfileBinding::bind)
    override val viewModel: SignInViewModel by viewModels<SignInViewModel>()
    @Inject
    lateinit var userPreferences: UserPreferences

    override fun initListeners() {
        super.initListeners()
        setBottomSheet()
        clickers()
    }

    override fun initialize() {
        super.initialize()
        binding.tvName.hint = "ФИО"
        getSharedData()
    }

    private fun getSharedData() {
        val pref = activity?.getSharedPreferences("preferences_profile",Context.MODE_PRIVATE)
        val id = pref?.getString("fio","")
        binding.tvName.text = id
    }

    private fun clickers() {
        with(binding) {
            btnProfile.setOnClickListener {
                findNavController().navigate(R.id.fillProfileFragment)
            }
        }
    }

    private fun setBottomSheet() {
        binding.btnExit.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.exit_bottom_sheet, null)
            val dialog = BottomSheetDialog(requireActivity())
            dialog.setContentView(view)
            val btnDismiss = dialog.findViewById<Button>(R.id.btn_back)
            val btnLeave = dialog.findViewById<Button>(R.id.btn_confirm)

            btnDismiss?.setOnClickListener {
                dialog.dismiss()
            }
            btnLeave?.setOnClickListener {
              onLogOut()
            }
            dialog.show()
        }

        binding.btnDeleteAccount.setOnClickListener{
            val view: View = layoutInflater.inflate(R.layout.delete_account_bottom_sheet, null)
            val dialog = BottomSheetDialog(requireActivity())
            dialog.setContentView(view)
            val btnDelete = dialog.findViewById<Button>(R.id.btn_delete_dabs)
            val btnCancel = dialog.findViewById<Button>(R.id.btn_cancel_dabs)

            btnDelete?.setOnClickListener {
               showToast("delete account")
            }
            btnCancel?.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }

    private fun onLogOut() {
       userPreferences.removeData()
       activity?.finish()

    }
}
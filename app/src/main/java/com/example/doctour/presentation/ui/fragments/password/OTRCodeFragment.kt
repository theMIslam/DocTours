package com.example.doctour.presentation.ui.fragments.password

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentOTRCodeBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OTRCodeFragment(

) : BaseFragment<FragmentOTRCodeBinding, PasswordViewModel>(
    R.layout.fragment_o_t_r_code
) {
    override val binding: FragmentOTRCodeBinding by viewBinding(FragmentOTRCodeBinding::bind)
    override val viewModel: PasswordViewModel by viewModels<PasswordViewModel>()

    override fun initListeners() {
        super.initListeners()
        binding.btnSend.setOnClickListener {
            findNavController().navigate(R.id.newPasswordFragment)
        }
    }
}
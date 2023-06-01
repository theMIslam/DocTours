package com.example.doctour.presentation.ui.fragments.appoiment

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentCancelledSuccessBinding
import com.example.doctour.data.base.BaseFragment

class AppoimentCancelledSuccessFragment
    : BaseFragment<FragmentAppoimentCancelledSuccessBinding, AppoimentViewModel>(
    R.layout.fragment_appoiment_cancelled_success
    ) {

    override val binding: FragmentAppoimentCancelledSuccessBinding by viewBinding(FragmentAppoimentCancelledSuccessBinding::bind)
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()

}
package com.example.doctour.presentation.ui.fragments.appoiment

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentCancelledFailedBinding
import com.example.doctour.presentation.base.BaseFragment

class AppoimentCancelledFailedFragment :
    BaseFragment<FragmentAppoimentCancelledFailedBinding, AppoimentViewModel>
        (R.layout.fragment_appoiment_cancelled_failed) {

    override val binding: FragmentAppoimentCancelledFailedBinding by viewBinding(FragmentAppoimentCancelledFailedBinding::bind)
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()

}
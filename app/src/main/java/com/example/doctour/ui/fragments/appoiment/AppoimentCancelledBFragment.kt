package com.example.doctour.ui.fragments.appoiment

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentCancelledBBinding
import com.example.doctour.presentation.core.base.BaseFragment

class AppoimentCancelledBFragment :
    BaseFragment<FragmentAppoimentCancelledBBinding, AppoimentViewModel>
        (R.layout.fragment_appoiment_cancelled_b) {

    override val binding: FragmentAppoimentCancelledBBinding by viewBinding(FragmentAppoimentCancelledBBinding::bind)
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()
    private val adapter : CancelledBAdapter by lazy {
        CancelledBAdapter()
    }

}
package com.example.doctour.presentation.ui.fragments.appoiment

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentRescheduleSuccessBinding
import com.example.doctour.presentation.base.BaseFragment

class AppoimentRescheduleSuccessFragment
    : BaseFragment<FragmentAppoimentRescheduleSuccessBinding, AppoimentViewModel>(
    R.layout.fragment_appoiment_reschedule_success
    ){

    override val binding: FragmentAppoimentRescheduleSuccessBinding by viewBinding(FragmentAppoimentRescheduleSuccessBinding::bind)
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()
}
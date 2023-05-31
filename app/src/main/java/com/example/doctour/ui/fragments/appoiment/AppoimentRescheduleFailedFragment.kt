package com.example.doctour.ui.fragments.appoiment

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentRescheduleFailedBinding
import com.example.doctour.presentation.core.base.BaseFragment

class AppoimentRescheduleFailedFragment
    :BaseFragment<FragmentAppoimentRescheduleFailedBinding,AppoimentViewModel>
    (R.layout.fragment_appoiment_reschedule_failed){

    override val binding: FragmentAppoimentRescheduleFailedBinding by viewBinding(FragmentAppoimentRescheduleFailedBinding::bind)
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()
}
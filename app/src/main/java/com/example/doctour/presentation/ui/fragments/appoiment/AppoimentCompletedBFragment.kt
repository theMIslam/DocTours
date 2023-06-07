package com.example.doctour.presentation.ui.fragments.appoiment

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentCompletedBBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppoimentCompletedBFragment :
    BaseFragment<FragmentAppoimentCompletedBBinding, AppoimentViewModel>
        (R.layout.fragment_appoiment_completed_b) {

    override val binding: FragmentAppoimentCompletedBBinding by viewBinding(
        FragmentAppoimentCompletedBBinding::bind
    )
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()

    private val adapter: CompletedBAdapter by lazy {
        CompletedBAdapter(this::btnSchedule, this::btnLeaveFeedBack)
    }

    private fun btnLeaveFeedBack() {

    }

    private fun btnSchedule() {

    }
}
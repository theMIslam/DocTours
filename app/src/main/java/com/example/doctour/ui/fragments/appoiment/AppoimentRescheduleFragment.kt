package com.example.doctour.ui.fragments.appoiment

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.core.base.BaseFragment
import com.example.doctour.databinding.FragmentAppoimentRescheduleBinding

class AppoimentRescheduleFragment :
    BaseFragment<FragmentAppoimentRescheduleBinding,AppoimentViewModel>
        (R.layout.fragment_appoiment_reschedule) {

    override val binding: FragmentAppoimentRescheduleBinding by viewBinding(FragmentAppoimentRescheduleBinding::bind)
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()

    override fun initListeners() {
        super.initListeners()
        binding.btnChange.setOnClickListener {
         binding.includeAppoimentRescheduleSuccess.root.isVisible=true
        }
    }
}
package com.example.doctour.ui.fragments.appoiment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.core.base.BaseFragment
import com.example.doctour.databinding.FragmentAppoimentCancelledBBinding

class AppoimentCancelledBFragment :
    BaseFragment<FragmentAppoimentCancelledBBinding,AppoimentViewModel>
        (R.layout.fragment_appoiment_cancelled_b) {

    override val binding: FragmentAppoimentCancelledBBinding by viewBinding(FragmentAppoimentCancelledBBinding::bind)
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()
    private val adapter : CancelledBAdapter by lazy {
        CancelledBAdapter()
    }

}
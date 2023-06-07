package com.example.doctour.presentation.ui.fragments.appoiment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentAppoimentUpcomingBBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.ui.fragments.appoiment.adapter.UpComingBAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppoimentUpcomingBFragment :
    BaseFragment<FragmentAppoimentUpcomingBBinding, AppoimentViewModel>
        (R.layout.fragment_appoiment_upcoming_b) {

    override val binding: FragmentAppoimentUpcomingBBinding by viewBinding(
        FragmentAppoimentUpcomingBBinding::bind
    )
    override val viewModel: AppoimentViewModel by viewModels<AppoimentViewModel>()
    private val adapter: UpComingBAdapter by lazy {
        UpComingBAdapter(this::btnCancelClick, this::btnReSheduleClick)
    }


    override fun initListeners() {
        super.initListeners()
        onClickListeners()
    }

    private fun onClickListeners() {

    }

    private fun btnCancelClick() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.exit_bottom_sheet)
        val btnBack = dialog.findViewById<TextView>(R.id.bsh_btn_back)
        val btnConfirm = dialog.findViewById<TextView>(R.id.btn_apply)
        btnBack.setOnClickListener {
            binding.includeAppoimentCancelledSuccess.root.isVisible=false
        }
        btnConfirm.setOnClickListener {
            binding.includeAppoimentCancelledSuccess.root.isVisible = true
        }
        dialog.show()
        dialog.window?.apply {
            setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            attributes.windowAnimations = R.style.BottomDialogAnimation
            setGravity(Gravity.BOTTOM)
        }
    }

    private fun btnReSheduleClick() {
        findNavController().navigate(R.id.appoimentRescheduleFragment)
    }
}
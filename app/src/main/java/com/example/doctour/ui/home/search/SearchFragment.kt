package com.example.doctour.ui.home.search

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.core.base.BaseFragment
import com.example.doctour.databinding.FragmentSearchBinding

@SuppressLint("ClickableViewAccessibility")
class SearchFragment :
    BaseFragment<FragmentSearchBinding,SearchViewModel>
        (R.layout.fragment_search) {

    override val binding: FragmentSearchBinding by  viewBinding(FragmentSearchBinding::bind)
    override val viewModel: SearchViewModel by viewModels<SearchViewModel>()

    override fun initListeners() {
        super.initListeners()
        onClickListeners()
    }
    private fun onClickListeners() {
        binding.etSearch.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.x >= (binding.etSearch.width - binding.etSearch.compoundDrawables[DRAWABLE_RIGHT].bounds.width())
                ) {
                    showBottomDialog()
                    return@setOnTouchListener true}}
            return@setOnTouchListener false }

        binding.tvArrowBack.setOnClickListener {
            //findNavController().navigateUp()
        }
        binding.tvAll.setOnClickListener {
            //action
        }
        binding.tvDentist.setOnClickListener {
            //action
        }
        binding.tvPediatric.setOnClickListener {
            //action
        }
        binding.tvEyeDoc.setOnClickListener {
            //action
        }
    }

    private fun showBottomDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog)
        val btnRelease = dialog.findViewById<TextView>(R.id.btn_release)
        val btnApply = dialog.findViewById<TextView>(R.id.btn_apply)
        btnRelease.setOnClickListener {
            //action
        }
        btnApply.setOnClickListener {
            //action
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
    companion object {
        const val DRAWABLE_RIGHT = 2
    }
}
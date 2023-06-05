package com.example.doctour.presentation.ui.home.search

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentSearchBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.extensions.showToast
import com.example.doctour.presentation.ui.fragments.appoiment.model.BermetModel

@SuppressLint("ClickableViewAccessibility")
class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewModel>
        (R.layout.fragment_search) {

    private var myAdapter: SearchAdapter? = null
    private var users = ArrayList<BermetModel>()

    override val binding: FragmentSearchBinding by  viewBinding(FragmentSearchBinding::bind)
    override val viewModel: SearchViewModel by viewModels<SearchViewModel>()

    override fun initListeners() {
        super.initListeners()
        myAdapter = SearchAdapter(users,this::onItemClick)
        binding.rv.adapter = myAdapter
        onClickListeners()
    }

    private fun onItemClick(bermetModel: BermetModel) {
      findNavController().navigate(R.id.aboutDoctorFragment)
    }

    private fun onClickListeners() {

        binding.etSearch.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.x >= (binding.etSearch.width - binding.etSearch.compoundDrawables[DRAWABLE_RIGHT].bounds.width())
                ) {
                    showBottomDialog()
                    return@setOnTouchListener true}}
            return@setOnTouchListener false }
        binding.etSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(ediatble: Editable?) {
                filterText(ediatble.toString())
            }
        })

        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.tvAll.setOnClickListener {
            showToast("Все")
        }
        binding.tvDentist.setOnClickListener {
            showToast("Дантист")
        }
        binding.tvPediatric.setOnClickListener {
            showToast("Педиатр")
        }
        binding.tvEyeDoc.setOnClickListener {
            showToast("Окулист")
        }
    }

    private fun filterText(text: String) {
        val filteredNames = ArrayList<BermetModel>()
        users.filterTo(filteredNames) {
            it.name.toLowerCase().contains(text.toLowerCase())
        }
        myAdapter!!.filterList(filteredNames)
    }

    private fun showBottomDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog)
        val btnRelease = dialog.findViewById<TextView>(R.id.btn_release)
        val btnApply = dialog.findViewById<TextView>(R.id.btn_apply)
        val btnAll = dialog.findViewById<TextView>(R.id.btnAll_bottom)
        val btnPediatrik = dialog.findViewById<TextView>(R.id.btnPediatrik_bottom)
        val btnDentist = dialog.findViewById<TextView>(R.id.btnDentist_bottom)
        val btnEyeDoctor = dialog.findViewById<TextView>(R.id.btnEyeDoctor_bottom)
        val btnBishkek = dialog.findViewById<TextView>(R.id.btnBishkek_bottom)
        val btnOsh = dialog.findViewById<TextView>(R.id.btnOsh_bottom)

        btnRelease.setOnClickListener {
            showToast("Release")
        }
        btnApply.setOnClickListener {
           showToast("Apply")
        }
        btnAll.setOnClickListener {
            showToast("All")
        }
        btnPediatrik.setOnClickListener {
            showToast("Pediatrik")
        }
        btnDentist.setOnClickListener {
            showToast("Dentis")
        }
        btnEyeDoctor.setOnClickListener {
            showToast("Eye")
        }
        btnBishkek.setOnClickListener {
            showToast("Bishkek")
        }
        btnOsh.setOnClickListener {
            showToast("Osh")
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
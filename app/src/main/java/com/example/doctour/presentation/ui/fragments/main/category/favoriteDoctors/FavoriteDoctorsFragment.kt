package com.example.doctour.presentation.ui.fragments.main.category.favoriteDoctors


import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentFavoriteDoctorsBinding
import com.example.doctour.presentation.extensions.showToast
import com.example.doctour.presentation.model.DoctorUi
import com.example.doctour.presentation.ui.fragments.main.category.favoriteDoctors.adapter.FavoriteDoctorsAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteDoctorsFragment
    : BaseFragment<FragmentFavoriteDoctorsBinding, FavoriteDoctorsViewModel>(
    R.layout.fragment_favorite_doctors
) {
    override val binding: FragmentFavoriteDoctorsBinding by viewBinding(
        FragmentFavoriteDoctorsBinding::bind
    )
    override val viewModel: FavoriteDoctorsViewModel by viewModels()
    private lateinit var adapterFavoriteDoctor: FavoriteDoctorsAdapter
    private var list = arrayListOf<DoctorUi>()

    override fun initListeners() {
        super.initListeners()
        binding.imgBack.setOnClickListener {
          findNavController().navigateUp()
        }
    }

    override fun initialize() {
        super.initialize()
        adapterFavoriteDoctor = FavoriteDoctorsAdapter(this::onClick,this::onLongClick)
        binding.rv.adapter = adapterFavoriteDoctor

        adapterFavoriteDoctor.addLoadStateListener {loadState ->
            binding.rv.isVisible= loadState.refresh is  LoadState.NotLoading
            binding.progressBar.isVisible= loadState.refresh is  LoadState.Loading
        }
    }


    private fun onClick(doctorUi: DoctorUi) {
        showToast("onClick")
    }

    private fun onLongClick(doctor: DoctorUi) {
        val view: View = layoutInflater.inflate(R.layout.remove_favorite_bottom_sheet, null)
        val dialog = BottomSheetDialog(requireActivity())
        dialog.setContentView(view)
        val btnRemove = dialog.findViewById<Button>(R.id.bsh_btn_confirm)
        val btnCancel = dialog.findViewById<Button>(R.id.bsh_btn_back)

        btnRemove?.setOnClickListener {
            showToast("Remove")
        }
        btnCancel?.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}

package com.example.doctour.presentation.ui.fragments.main.category.favoriteDoctors


import android.app.Dialog
import android.view.Window
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentFavoriteDoctorsBinding
import com.example.doctour.presentation.extensions.showToast
import com.example.doctour.presentation.model.DoctorUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteDoctorsFragment
    : BaseFragment<FragmentFavoriteDoctorsBinding, FavoriteDoctorsViewModel>(
    R.layout.fragment_favorite_doctors
) {

    override val binding: FragmentFavoriteDoctorsBinding by viewBinding(FragmentFavoriteDoctorsBinding::bind)
    override val viewModel: FavoriteDoctorsViewModel by viewModels()
    private lateinit var adapterFavoriteDoctor: FavoriteDoctorsAdapter

    override fun initListeners() {
        super.initListeners()
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun initialize() {
        super.initialize()
        adapterFavoriteDoctor= FavoriteDoctorsAdapter(this::onClick,this::onLongClick)
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapterFavoriteDoctor
    }
    override fun initRequest() {
        super.initRequest()
        adapterFavoriteDoctor.addLoadStateListener { loadStates ->
            binding.rv.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadStates.refresh is LoadState.Loading
        }
        getFavDoctors()
    }

    private fun getFavDoctors() {
        viewModel.getAllFavoriteDoctors().collectPaging {
            adapterFavoriteDoctor.submitData(it)
        }
    }
    private fun onClick(doctor: DoctorUi){

    }
    private fun onLongClick(doctor: DoctorUi){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.remove_favorite_bottom_sheet)
        val btnRemove = dialog.findViewById<Button>(R.id.bsh_btn_confirm)
        val btnCancel = dialog.findViewById<Button>(R.id.bsh_btn_back)

        btnRemove.setOnClickListener {
            //remove from favorite
            showToast("Remove")
        }
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
    }
}
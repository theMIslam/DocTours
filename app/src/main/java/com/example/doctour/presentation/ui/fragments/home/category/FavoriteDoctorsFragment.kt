package com.example.doctour.presentation.ui.fragments.home.category


import android.app.Dialog
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentFavoriteDoctorsBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.ui.fragments.home.category.adapter.FavoriteDoctorsAdapter
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteDoctorsFragment : BaseFragment<FragmentFavoriteDoctorsBinding,CategoryViewModel>(
    R.layout.fragment_favorite_doctors
) {

    override val binding: FragmentFavoriteDoctorsBinding by viewBinding(FragmentFavoriteDoctorsBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()
    private val adapterFavoriteDoctor = FavoriteDoctorsAdapter(this::onClick,this::onLongClick)

    override fun initListeners() {
        super.initListeners()
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
    private fun onClick(){}
    private fun onLongClick(){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.remove_favorite_bottom_sheet)
        val btnRemove = dialog.findViewById<Button>(R.id.bsh_btn_confirm)
        val btnCancel = dialog.findViewById<Button>(R.id.bsh_btn_back)

        btnRemove.setOnClickListener {
            //remove from favorite
        }
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
    }
}
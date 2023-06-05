package com.example.doctour.presentation.ui.review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.doctour.R
import com.example.doctour.databinding.FragmentWriteReviewBinding

class WriteReviewFragment : Fragment() {

    private lateinit var binding: FragmentWriteReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteReviewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickers()
    }

    private fun clickers() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.appoimentUpcomingBFragment)
        }
        binding.btnSend.setOnClickListener {
            //нужно получить ответ с сервера и показать состояние
            findNavController().navigate(R.id.fragment_review_success)
        }
        binding.rbtnYes.setOnClickListener {
            //change color
        }
        binding.rbtnNo.setOnClickListener {
            //change color
        }
        if (binding.etYourReview.text.isEmpty()) {
            Toast.makeText(this@WriteReviewFragment, getString(R.string.write_your_review_toast), Toast.LENGTH_SHORT)
                .show()
        }
    }
}
package com.example.doctour.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doctour.R
import com.example.doctour.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
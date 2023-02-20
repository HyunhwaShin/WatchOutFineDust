package com.example.watchoutfinedust.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.watchoutfinedust.databinding.ActivityMyAreaBinding

class MyAreaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMyAreaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyAreaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
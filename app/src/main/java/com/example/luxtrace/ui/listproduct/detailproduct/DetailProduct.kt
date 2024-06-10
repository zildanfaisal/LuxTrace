package com.example.luxtrace.ui.listproduct.detailproduct

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityDetailProductBinding
import com.google.android.material.appbar.MaterialToolbar

class DetailProduct : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topAppBar: MaterialToolbar = findViewById(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            // Handle back button press
            onBackPressed()
        }
    }
}
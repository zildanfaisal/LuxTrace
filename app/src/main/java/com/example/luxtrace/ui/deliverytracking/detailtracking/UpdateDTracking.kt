package com.example.luxtrace.ui.deliverytracking.detailtracking

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityUpdateDtrackingBinding

class UpdateDTracking : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUpdateDtrackingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateDtrackingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitUpdateDT.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnSubmitUpdateDT.id -> {
                val moveIntent = Intent(this@UpdateDTracking, DetailDTracking::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
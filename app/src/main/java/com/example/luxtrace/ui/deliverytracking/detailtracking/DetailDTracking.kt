package com.example.luxtrace.ui.deliverytracking.detailtracking

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityDetailDtrackingBinding
import com.example.luxtrace.ui.creatematerial.CreateMaterial

class DetailDTracking : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailDtrackingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDtrackingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdateTracking.setOnClickListener(this)
        binding.btnSignOff.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnUpdateTracking.id -> {
                val moveIntent = Intent(this@DetailDTracking, UpdateDTracking::class.java)
                startActivity(moveIntent)
            }
            binding.btnSignOff.id -> {
                val moveIntent = Intent(this@DetailDTracking, SignOffDTracking::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
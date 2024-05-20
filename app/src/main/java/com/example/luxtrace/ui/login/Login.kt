package com.example.luxtrace.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityLoginBinding
import com.example.luxtrace.ui.dashboard.Dashboard

class Login : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.loginButton.id -> {
                val moveIntent = Intent(this@Login, Dashboard::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
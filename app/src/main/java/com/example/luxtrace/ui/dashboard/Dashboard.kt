package com.example.luxtrace.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityDashboardBinding
import com.example.luxtrace.ui.creatematerial.CreateMaterial
import com.example.luxtrace.ui.createproduct.CreateProduct
import com.example.luxtrace.ui.deliverytracking.DeliveryTracking
import com.example.luxtrace.ui.deliverytracking.ListDeliveryTracking
import com.example.luxtrace.ui.listmaterial.ListMaterial
import com.example.luxtrace.ui.listmaterial.detailmaterial.DetailMaterial
import com.example.luxtrace.ui.listproduct.ListProduct
import com.example.luxtrace.ui.login.Login
import com.example.luxtrace.ui.processingproduct.ListProcessingProduct
import com.example.luxtrace.ui.processingproduct.ProcessingProduct
import com.example.luxtrace.ui.splashscreen.SplashScreen

class Dashboard : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cMaterialButton.setOnClickListener(this)
        binding.lMaterialButton.setOnClickListener(this)
        binding.cProductButton.setOnClickListener(this)
        binding.pProductButton.setOnClickListener(this)
        binding.lProductButton.setOnClickListener(this)
        binding.dTrackingButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.cMaterialButton.id -> {
                val moveIntent = Intent(this@Dashboard, CreateMaterial::class.java)
                startActivity(moveIntent)
            }
            binding.lMaterialButton.id -> {
                val moveIntent = Intent(this@Dashboard, ListMaterial::class.java)
                startActivity(moveIntent)
            }
            binding.cProductButton.id -> {
                val moveIntent = Intent(this@Dashboard, CreateProduct::class.java)
                startActivity(moveIntent)
            }
            binding.pProductButton.id -> {
                val moveIntent = Intent(this@Dashboard, ListProcessingProduct::class.java)
                startActivity(moveIntent)
            }
            binding.lProductButton.id -> {
                val moveIntent = Intent(this@Dashboard, ListProduct::class.java)
                startActivity(moveIntent)
            }
            binding.dTrackingButton.id -> {
                val moveIntent = Intent(this@Dashboard, ListDeliveryTracking::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
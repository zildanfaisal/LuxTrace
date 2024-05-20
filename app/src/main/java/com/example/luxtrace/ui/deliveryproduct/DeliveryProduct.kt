package com.example.luxtrace.ui.deliveryproduct

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityDeliveryProductBinding
import com.example.luxtrace.ui.dashboard.Dashboard

class DeliveryProduct : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDeliveryProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveryProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemSNProduct = listOf(
            "Atlas Sneaker White",
            "Saki Sneakers - Soybean",
            "Kotta Hybrid Sneakers - Skeleton",
            "Tiga Slip-On Sneakers - Cerulean Blue",
            "PIJAK BUMI x Kevinswork x Bluesville Sakka Batik",
            "Atlas Eceng Hi Top Sneaker White"

        )
        val adapterSNProduct = ArrayAdapter(this, R.layout.list_items, itemSNProduct)

        val itemSShipper = listOf(
            "Adi Pratama",
            "Citra Dewi",
            "Budi Hartono",
            "Deni Setiawan",
            "Eka Putri",
            "Faisal Akbar",
            "Kevin Akbar",
            "Putra Hadi"
        )
        val adapterSShipper = ArrayAdapter(this, R.layout.list_items, itemSShipper)

        val itemDShop = listOf(
            "Jakarta-PasarMinggu-12520",
            "Bekasi-BekasiTimur-17113",
            "Depok-Cimanggis-16452",
            "Tangerang-Serpong-15310",
            "Bogor-Baranangsiang-16143",
            "Jakarta-Kemang-12730"
        )
        val adapterDShop = ArrayAdapter(this, R.layout.list_items, itemDShop)

        binding.snProductDropdown.setAdapter(adapterSNProduct)
        binding.sShipperDropdown.setAdapter(adapterSShipper)
        binding.sDestiantionShopDropdown.setAdapter(adapterDShop)

        binding.btnSubmitDProduct.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnSubmitDProduct.id -> {
                val moveIntent = Intent(this@DeliveryProduct, Dashboard::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
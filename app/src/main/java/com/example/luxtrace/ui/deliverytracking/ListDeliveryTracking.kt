package com.example.luxtrace.ui.deliverytracking

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityListDeliveryTrackingBinding
import com.example.luxtrace.ui.deliveryproduct.DeliveryProduct
import com.google.android.material.appbar.MaterialToolbar

class ListDeliveryTracking : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityListDeliveryTrackingBinding
    private lateinit var rvDeliveryTracking: RecyclerView
    private val list = ArrayList<DeliveryTracking>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDeliveryTrackingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvDeliveryTracking = findViewById(R.id.rvDeliveryTracking)
        rvDeliveryTracking.setHasFixedSize(true)

        binding.btnDProduct.setOnClickListener(this)

        val topAppBar: MaterialToolbar = findViewById(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            // Handle back button press
            onBackPressed()
        }

        list.addAll(getListDeliveryTracking())
        showRecyclerList()
    }

    private fun getListDeliveryTracking(): ArrayList<DeliveryTracking> {
        val dataName = resources.getStringArray(R.array.dnProduct)
        val dataDescription = resources.getStringArray(R.array.ddProduct)
        val dataPhoto = resources.obtainTypedArray(R.array.dpProduct)
        val listDeliveryTracking = ArrayList<DeliveryTracking>()
        for (i in dataName.indices) {
            val deliveryTracking = DeliveryTracking(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listDeliveryTracking.add(deliveryTracking)
        }
        return listDeliveryTracking
    }

    private fun showRecyclerList() {
        rvDeliveryTracking.layoutManager = LinearLayoutManager(this)
        val listDeliveryTrackingAdapter = ListDeliveryTrackingAdapter(list)
        rvDeliveryTracking.adapter = listDeliveryTrackingAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnDProduct.id -> {
                val moveIntent = Intent(this@ListDeliveryTracking, DeliveryProduct::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
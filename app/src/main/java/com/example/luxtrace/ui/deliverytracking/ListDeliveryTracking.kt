package com.example.luxtrace.ui.deliverytracking

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.luxtrace.R

class ListDeliveryTracking : AppCompatActivity() {

    private lateinit var rvDeliveryTracking: RecyclerView
    private val list = ArrayList<DeliveryTracking>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_delivery_tracking)

        rvDeliveryTracking = findViewById(R.id.rvDeliveryTracking)
        rvDeliveryTracking.setHasFixedSize(true)

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
}
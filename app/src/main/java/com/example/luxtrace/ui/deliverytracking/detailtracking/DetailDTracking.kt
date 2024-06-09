package com.example.luxtrace.ui.deliverytracking.detailtracking

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
import com.example.luxtrace.databinding.ActivityDetailDtrackingBinding
import com.example.luxtrace.ui.creatematerial.CreateMaterial
import com.example.luxtrace.ui.deliverytracking.DeliveryTracking
import com.example.luxtrace.ui.deliverytracking.ListDeliveryTrackingAdapter
import com.example.luxtrace.ui.processingproduct.ListProcessingProductAdapter
import com.example.luxtrace.ui.processingproduct.ProcessingProduct

class DetailDTracking : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailDtrackingBinding
    private lateinit var rvUpdateDeliveryTracking: RecyclerView
    private val list = ArrayList<UpdateDeliveryTracking>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDtrackingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.btnUpdateTracking.setOnClickListener(this)
        binding.btnSignOff.setOnClickListener(this)

        rvUpdateDeliveryTracking = findViewById(R.id.rvUpdateTracking)
        rvUpdateDeliveryTracking.setHasFixedSize(true)

        list.addAll(getListUpdateDeliveryTracking())
        showRecyclerList()
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

    private fun getListUpdateDeliveryTracking(): ArrayList<UpdateDeliveryTracking> {
        val dataDate = resources.getStringArray(R.array.utDate)
        val dataDescription = resources.getStringArray(R.array.utDescription)
        val dataStatus = resources.getStringArray(R.array.utStatus)
        val updateDeliveryTracking = ArrayList<UpdateDeliveryTracking>()
        for (i in dataDate.indices) {
            val upTracking = UpdateDeliveryTracking(dataDate[i], dataDescription[i], dataStatus[i])
            updateDeliveryTracking.add(upTracking)
        }
        return updateDeliveryTracking
    }

    private fun showRecyclerList() {
        rvUpdateDeliveryTracking.layoutManager = LinearLayoutManager(this)
        val updateDeliveryTrackingAdapter = UpdateDeliveryTrackingAdapter(list)
        rvUpdateDeliveryTracking.adapter = updateDeliveryTrackingAdapter
    }
}
package com.example.luxtrace.ui.processingproduct

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
import com.example.luxtrace.databinding.ActivityListProcessingProductBinding
import com.example.luxtrace.ui.createproduct.CreateProduct
import com.example.luxtrace.ui.deliveryproduct.DeliveryProduct

class ListProcessingProduct : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityListProcessingProductBinding
    private lateinit var rvProcessingProduct: RecyclerView
    private val list = ArrayList<ProcessingProduct>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProcessingProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.btnCreateProduct.setOnClickListener(this)

        rvProcessingProduct = findViewById(R.id.rvProcessingProduct)
        rvProcessingProduct.setHasFixedSize(true)

        list.addAll(getListProcessingProduct())
        showRecyclerList()
    }

    private fun getListProcessingProduct(): ArrayList<ProcessingProduct> {
        val dataName = resources.getStringArray(R.array.dnProduct)
        val dataStatus = resources.getStringArray(R.array.dsProduct)
        val dataDescription = resources.getStringArray(R.array.ddProduct)
        val listProcessingProduct = ArrayList<ProcessingProduct>()
        for (i in dataName.indices) {
            val processingProduct = ProcessingProduct(dataName[i], dataStatus[i], dataDescription[i])
            listProcessingProduct.add(processingProduct)
        }
        return listProcessingProduct
    }

    private fun showRecyclerList() {
        rvProcessingProduct.layoutManager = LinearLayoutManager(this)
        val listProcessingProductAdapter = ListProcessingProductAdapter(list)
        rvProcessingProduct.adapter = listProcessingProductAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCreateProduct.id -> {
                val moveIntent = Intent(this@ListProcessingProduct, CreateProduct::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
package com.example.luxtrace.ui.processingproduct

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.luxtrace.R

class ListProcessingProduct : AppCompatActivity() {

    private lateinit var rvProcessingProduct: RecyclerView
    private val list = ArrayList<ProcessingProduct>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_processing_product)

        rvProcessingProduct = findViewById(R.id.rvProcessingProduct)
        rvProcessingProduct.setHasFixedSize(true)

        list.addAll(getListProcessingProduct())
        showRecyclerList()
    }

    private fun getListProcessingProduct(): ArrayList<ProcessingProduct> {
        val dataName = resources.getStringArray(R.array.dnProduct)
        val dataDescription = resources.getStringArray(R.array.ddProduct)
        val listProcessingProduct = ArrayList<ProcessingProduct>()
        for (i in dataName.indices) {
            val processingProduct = ProcessingProduct(dataName[i], dataDescription[i])
            listProcessingProduct.add(processingProduct)
        }
        return listProcessingProduct
    }

    private fun showRecyclerList() {
        rvProcessingProduct.layoutManager = LinearLayoutManager(this)
        val listProcessingProductAdapter = ListProcessingProductAdapter(list)
        rvProcessingProduct.adapter = listProcessingProductAdapter
    }
}
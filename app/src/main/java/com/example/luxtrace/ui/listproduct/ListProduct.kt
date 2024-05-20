package com.example.luxtrace.ui.listproduct

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityListProductBinding
import com.example.luxtrace.ui.creatematerial.CreateMaterial
import com.example.luxtrace.ui.deliveryproduct.DeliveryProduct

class ListProduct : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityListProductBinding
    private lateinit var rvProduct: RecyclerView
    private val list = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvProduct = findViewById(R.id.rvProduct)
        rvProduct.setHasFixedSize(true)

        binding.btnDProduct.setOnClickListener(this)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    private fun getListHeroes(): ArrayList<Product> {
        val dataName = resources.getStringArray(R.array.dnProduct)
        val dataDescription = resources.getStringArray(R.array.ddProduct)
        val dataPhoto = resources.obtainTypedArray(R.array.dpProduct)
        val listProduct = ArrayList<Product>()
        for (i in dataName.indices) {
            val product = Product(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listProduct.add(product)
        }
        return listProduct
    }

    private fun showRecyclerList() {
        rvProduct.layoutManager = LinearLayoutManager(this)
        val listProductAdapter = ListProductAdapter(list)
        rvProduct.adapter = listProductAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnDProduct.id -> {
                val moveIntent = Intent(this@ListProduct, DeliveryProduct::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
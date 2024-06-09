package com.example.luxtrace.ui.listmaterial

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
import com.example.luxtrace.databinding.ActivityListMaterialBinding
import com.example.luxtrace.ui.creatematerial.CreateMaterial
import com.example.luxtrace.ui.deliveryproduct.DeliveryProduct

class ListMaterial : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityListMaterialBinding
    private lateinit var rvMaterial: RecyclerView
    private val list = ArrayList<Material>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.btnCreateMaterial.setOnClickListener(this)

        rvMaterial = findViewById(R.id.rvMaterial)
        rvMaterial.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    private fun getListHeroes(): ArrayList<Material> {
        val dataName = resources.getStringArray(R.array.dnMaterial)
        val dataDescription = resources.getStringArray(R.array.ddMaterial)
        val dataPhoto = resources.obtainTypedArray(R.array.dpMaterial)
        val listHero = ArrayList<Material>()
        for (i in dataName.indices) {
            val hero = Material(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvMaterial.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListMaterialAdapter(list)
        rvMaterial.adapter = listHeroAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCreateMaterial.id -> {
                val moveIntent = Intent(this@ListMaterial, CreateMaterial::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
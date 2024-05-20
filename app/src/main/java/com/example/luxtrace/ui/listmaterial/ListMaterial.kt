package com.example.luxtrace.ui.listmaterial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.luxtrace.R

class ListMaterial : AppCompatActivity() {

    private lateinit var rvMaterial: RecyclerView
    private val list = ArrayList<Material>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_material)

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
}
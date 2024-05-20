package com.example.luxtrace.ui.createproduct

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityCreateProductBinding
import com.example.luxtrace.ui.dashboard.Dashboard

class CreateProduct : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCreateProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemUMaterial = listOf(
            "Kenaf Fibers",
            "Kenaf",
            "Recycled Cotton",
            "Ramie (Red Pull Tap)",
            "Polyester",
            "Water Hyacinth"
        )
        val adapterUMaterial = ArrayAdapter(this, R.layout.list_items, itemUMaterial)
        val itemUCraftsman = listOf(
            "Craftsman 1 - Regi Muhammar",
            "Craftsman 2 - Alda Ellsa",
            "Craftsman 3 - Zildan Faisal",
            "Craftsman 4 - Wiwit Atika",
            "Craftsman 5 - Juanda Felix",
            "Craftsman 6 - Iqbal Inggil"
        )
        val adapterUCraftsman = ArrayAdapter(this, R.layout.list_items, itemUCraftsman)

        val itemIMaterial = listOf(
            "Latex",
            "Natural Rubber",
            "EVA"
        )
        val adapterIMaterial = ArrayAdapter(this, R.layout.list_items, itemIMaterial)
        val itemICraftsman = listOf(
            "Craftsman 1 - Regi Muhammar",
            "Craftsman 2 - Alda Ellsa",
            "Craftsman 3 - Zildan Faisal",
            "Craftsman 4 - Wiwit Atika",
            "Craftsman 5 - Juanda Felix",
            "Craftsman 6 - Iqbal Inggil"
        )
        val adapterICraftsman = ArrayAdapter(this, R.layout.list_items, itemICraftsman)

        val itemLMaterial = listOf(
            "Beech Tree Fiber",
            "Beech Trees Cellulose Fiber"
        )
        val adapterLMaterial = ArrayAdapter(this, R.layout.list_items, itemLMaterial)
        val itemLCraftsman = listOf(
            "Craftsman 1 - Regi Muhammar",
            "Craftsman 2 - Alda Ellsa",
            "Craftsman 3 - Zildan Faisal",
            "Craftsman 4 - Wiwit Atika",
            "Craftsman 5 - Juanda Felix",
            "Craftsman 6 - Iqbal Inggil"
        )
        val adapterLCraftsman = ArrayAdapter(this, R.layout.list_items, itemLCraftsman)

        val itemOMaterial = listOf(
            "Natural Raw Rubber (Crepe Sole)",
            "Thermoplastic Rubber",
            "Natural Rubber"
        )
        val adapterOMaterial = ArrayAdapter(this, R.layout.list_items, itemOMaterial)
        val itemOCraftsman = listOf(
            "Craftsman 1 - Regi Muhammar",
            "Craftsman 2 - Alda Ellsa",
            "Craftsman 3 - Zildan Faisal",
            "Craftsman 4 - Wiwit Atika",
            "Craftsman 5 - Juanda Felix",
            "Craftsman 6 - Iqbal Inggil"
        )
        val adapterOCraftsman = ArrayAdapter(this, R.layout.list_items, itemOCraftsman)

        val itemSLMaterial = listOf(
            "Recycled Polyester",
            "Recycled Polyester (rPET)",
            "Cotton",
            "Poly Cotton"
        )
        val adapterSLMaterial = ArrayAdapter(this, R.layout.list_items, itemSLMaterial)
        val itemSLCraftsman = listOf(
            "Craftsman 1 - Regi Muhammar",
            "Craftsman 2 - Alda Ellsa",
            "Craftsman 3 - Zildan Faisal",
            "Craftsman 4 - Wiwit Atika",
            "Craftsman 5 - Juanda Felix",
            "Craftsman 6 - Iqbal Inggil"
        )
        val adapterSLCraftsman = ArrayAdapter(this, R.layout.list_items, itemSLCraftsman)

        binding.uMaterialDropdown.setAdapter(adapterUMaterial)
        binding.uCraftsmanDropdown.setAdapter(adapterUCraftsman)

        binding.iMaterialDropdown.setAdapter(adapterIMaterial)
        binding.iCraftsmanDropdown.setAdapter(adapterICraftsman)

        binding.lMaterialDropdown.setAdapter(adapterLMaterial)
        binding.lCraftsmanDropdown.setAdapter(adapterLCraftsman)

        binding.oMaterialDropdown.setAdapter(adapterOMaterial)
        binding.oCraftsmanDropdown.setAdapter(adapterOCraftsman)

        binding.slMaterialDropdown.setAdapter(adapterSLMaterial)
        binding.slCraftsmanDropdown.setAdapter(adapterSLCraftsman)

        binding.btnCProduct.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.btnCProduct.id -> {
                val moveIntent = Intent(this@CreateProduct, Dashboard::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
package com.example.luxtrace.ui.creatematerial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityCreateMaterialBinding
import com.example.luxtrace.ui.dashboard.Dashboard

class CreateMaterial : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCreateMaterialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemJMaterial = listOf(
            "Upper",
            "Insole",
            "Outsole",
            "Lining",
            "Shoe Laces"
        )
        val adapterJMaterial = ArrayAdapter(this, R.layout.list_items, itemJMaterial)

        val itemPNPemasok = listOf(
            "PT Kenaf Indonesia - Jl. Kenaf Raya No. 10, Bandung",
            "Recycle Polyester Co. - Jl. Hijau Lestari No. 45, Jakarta",
            "Natural Rubber Ltd. - Jl. Karet Alam No. 89, Bogor",
            "Organic Cotton Corp. - Jl. Kapas Sejahtera No. 33, Depok",
            "Bamboo Fiber Co. - Jl. Bambu Indah No. 29, Tangerang"
        )
        val adapterPNPemasok = ArrayAdapter(this, R.layout.list_items, itemPNPemasok)

        binding.jMaterialDropdown.setAdapter(adapterJMaterial)
        binding.pnPemasokDropdown.setAdapter(adapterPNPemasok)

        binding.btnCMaterial.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.btnCMaterial.id -> {
                val moveIntent = Intent(this@CreateMaterial, Dashboard::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
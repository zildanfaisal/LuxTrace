package com.example.luxtrace.ui.creatematerial

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityCreateMaterialBinding
import com.example.luxtrace.ui.dashboard.Dashboard
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class CreateMaterial : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCreateMaterialBinding
    private lateinit var tpMaterialEditText: TextInputEditText

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

        // update
        tpMaterialEditText = findViewById(R.id.tpMaterialEditText)

        tpMaterialEditText.setOnClickListener {
            showDatePickerDialog()
        }

        tpMaterialEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showDatePickerDialog()
            }
        }

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.btnCMaterial.id -> {
                val moveIntent = Intent(this@CreateMaterial, Dashboard::class.java)
                startActivity(moveIntent)
            }
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                tpMaterialEditText.setText(selectedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
    }
}
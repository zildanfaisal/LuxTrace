package com.example.luxtrace.ui.creatematerial

import android.Manifest
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityCreateMaterialBinding
import com.example.luxtrace.ui.dashboard.Dashboard
import com.example.luxtrace.ui.utils.getFileNameFromUri
import com.example.luxtrace.ui.utils.getImageUri
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class CreateMaterial : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCreateMaterialBinding
    private lateinit var tpMaterialEditText: TextInputEditText
    private var currentImageUri: Uri? = null

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

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.jMaterialDropdown.setAdapter(adapterJMaterial)
        binding.pnPemasokDropdown.setAdapter(adapterPNPemasok)
        binding.btnCMaterial.setOnClickListener(this)
        binding.btnGallery.setOnClickListener { startGallery() }
        binding.btnCamera.setOnClickListener { startCamera() }

        // datePicker
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

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }

    private fun startCamera() {
        currentImageUri = getImageUri(this)
        launcherIntentCamera.launch(currentImageUri)
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            showImage()
        }
    }

    private fun showImage() {
        currentImageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.materialImageView.setImageURI(it)

            val fileName = getFileNameFromUri(this, it)
            Log.d("File Name", "showImage: $fileName")

            binding.fMaterialEditText.setText(fileName)
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

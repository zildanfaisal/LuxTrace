package com.example.luxtrace.ui.deliveryproduct

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityDeliveryProductBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException

class DeliveryProduct : AppCompatActivity() {

    private lateinit var binding: ActivityDeliveryProductBinding

    private lateinit var acPName: AutoCompleteTextView
    private lateinit var acShipper: AutoCompleteTextView
    private lateinit var edAmount: TextInputEditText
    private lateinit var acDShop: AutoCompleteTextView
    private lateinit var edDistance: TextInputEditText
    private lateinit var btnQR: Button
    private val multi = MultiFormatWriter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveryProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acPName = findViewById(R.id.snProductDropdown)
        acShipper = findViewById(R.id.sShipperDropdown)
        edAmount = findViewById(R.id.jmDeliveryProductEditText)
        acDShop = findViewById(R.id.sDestiantionShopDropdown)
        edDistance = findViewById(R.id.destinationDistanceEditText)
        btnQR = findViewById(R.id.btnSubmitDProduct)

        btnQR.setOnClickListener {
            val code = "Product Name: " + acPName.text.toString() +
                    "\nShipper: " + acShipper.text.toString() +
                    "\nAmount: " + edAmount.text.toString() +
                    "\nDestination: " + acDShop.text.toString() +
                    "\nDistance: " + edDistance.text.toString()
            try {
                val bitMatrix = multi.encode(code, BarcodeFormat.QR_CODE, 300, 300)
                val barcodeEncoder = BarcodeEncoder()
                val bitmap = barcodeEncoder.createBitmap(bitMatrix)

                val intent = Intent(this@DeliveryProduct, QRCodeActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable("qr_code_bitmap", bitmap)
                intent.putExtras(bundle)

                startActivity(intent)
            } catch (e: WriterException) {
                Toast.makeText(applicationContext, e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

        val itemSNProduct = listOf(
            "Atlas Sneaker White",
            "Saki Sneakers - Soybean",
            "Kotta Hybrid Sneakers - Skeleton",
            "Tiga Slip-On Sneakers - Cerulean Blue",
            "PIJAK BUMI x Kevinswork x Bluesville Sakka Batik",
            "Atlas Eceng Hi Top Sneaker White"

        )
        val adapterSNProduct = ArrayAdapter(this, R.layout.list_items, itemSNProduct)

        val itemSShipper = listOf(
            "Adi Pratama",
            "Citra Dewi",
            "Budi Hartono",
            "Deni Setiawan",
            "Eka Putri",
            "Faisal Akbar",
            "Kevin Akbar",
            "Putra Hadi"
        )
        val adapterSShipper = ArrayAdapter(this, R.layout.list_items, itemSShipper)

        val itemDShop = listOf(
            "Jakarta-PasarMinggu-12520",
            "Bekasi-BekasiTimur-17113",
            "Depok-Cimanggis-16452",
            "Tangerang-Serpong-15310",
            "Bogor-Baranangsiang-16143",
            "Jakarta-Kemang-12730"
        )
        val adapterDShop = ArrayAdapter(this, R.layout.list_items, itemDShop)

        binding.snProductDropdown.setAdapter(adapterSNProduct)
        binding.sShipperDropdown.setAdapter(adapterSShipper)
        binding.sDestiantionShopDropdown.setAdapter(adapterDShop)
    }
}
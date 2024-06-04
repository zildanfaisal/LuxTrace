package com.example.luxtrace.ui.deliveryproduct

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.luxtrace.R
import java.io.File
import java.io.FileOutputStream

class QRCodeActivity : AppCompatActivity() {

    private lateinit var imgQR: ImageView
    private lateinit var btnPrintQr: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)

        imgQR = findViewById(R.id.imgQRcode)
        btnPrintQr = findViewById(R.id.btnPrintBarcode)

        val bundle = intent.extras
        if (bundle != null) {
            val bitmap = bundle.getParcelable<Bitmap>("qr_code_bitmap")
            if (bitmap != null) {
                imgQR.setImageBitmap(bitmap)

                btnPrintQr.setOnClickListener{
                    saveQRCode(bitmap)
                }
            }
        }
    }

    private fun saveQRCode(bitmap: Bitmap) {
        if (ContextCompat.checkSelfPermission(this@QRCodeActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@QRCodeActivity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            return
        }

        val fileName = "QR_${System.currentTimeMillis()}.png"

        val directory = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "QRCodes")
        if (!directory.exists()) {
            directory.mkdirs()
        }

        val filePath = File(directory, fileName).absolutePath
        val outputStream = FileOutputStream(filePath)
        bitmap.compress(Bitmap.CompressFormat.PNG, 75, outputStream)
        outputStream.flush()
        outputStream.close()

        Toast.makeText(this@QRCodeActivity, "QR Code saved to: $filePath", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            saveQRCode(imgQR.drawable.current as Bitmap)
        } else {
            Toast.makeText(this@QRCodeActivity, "Permission to save QR Code denied", Toast.LENGTH_SHORT).show()
        }
    }
}
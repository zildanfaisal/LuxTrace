package com.example.luxtrace.ui.deliverytracking.detailtracking

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivitySignOffDtrackingBinding
import com.github.gcacace.signaturepad.views.SignaturePad
import com.google.android.material.appbar.MaterialToolbar
import java.util.Calendar

class SignOffDTracking : AppCompatActivity() {

    private var WRITE_EXTERNAL_STORAGE_PERMISSION_CODE: Int = 1
    private var READ_EXTERNAL_STORAGE_PERMISSION_CODE: Int = 2
    private lateinit var mSignature: SignaturePad
    private lateinit var mSignatureBitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_off_dtracking)

        val topAppBar: MaterialToolbar = findViewById(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            // Handle back button press
            onBackPressed()
        }

        checkPermission()
        init()
    }

    private fun checkPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when (PackageManager.PERMISSION_DENIED) {
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) -> {
                    requestPermissions(
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        WRITE_EXTERNAL_STORAGE_PERMISSION_CODE
                    )
                }
                checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                    requestPermissions(
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        READ_EXTERNAL_STORAGE_PERMISSION_CODE
                    )
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            WRITE_EXTERNAL_STORAGE_PERMISSION_CODE -> if (grantResults.isNotEmpty()) {
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "Anda perlu memberikan semua izin untuk menggunakan aplikasi ini.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
            READ_EXTERNAL_STORAGE_PERMISSION_CODE -> if (grantResults.isNotEmpty()) {
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "Anda perlu memberikan semua izin untuk menggunakan aplikasi ini.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

    private fun init() {
        mSignature = findViewById(R.id.signature_pad)
    }

    fun clickClear(view: View) {
        mSignature.clear()
    }

    fun clickSave(view: View) {
        mSignatureBitmap = mSignature.signatureBitmap
        val fileName = getFileName()
        val imgPath = saveImage(mSignatureBitmap,fileName)
        dialogSignature(mSignatureBitmap, imgPath)
    }

    private fun getFileName():String{
        return "${Calendar.getInstance().timeInMillis}.jpg"
    }

    private fun saveImage(myBitmap: Bitmap, nameFile: String): String {
        return MediaStore.Images.Media.insertImage(contentResolver, myBitmap, nameFile, null)
    }

    private fun dialogSignature(bitmap: Bitmap, imgPath: String){
        val builder = AlertDialog.Builder(this)
        val factory = LayoutInflater.from(this)
        val myView = factory.inflate(R.layout.dialog_signature, null)
        val ivResult = myView.findViewById<ImageView>(R.id.iv_result)

        builder.setView(myView)
        builder.setTitle("Signature")
        builder.setNegativeButton("Close"){ dialog, _ ->
            dialog.dismiss()
        }
        builder.setPositiveButton("Share"){ _, _ ->
            share(imgPath)
        }
        builder.show().withCenteredButtons()

        bitmap.let {
            Glide.with(this)
                .load(it)
                .into(ivResult)
        }
    }

    private fun AlertDialog.withCenteredButtons() {
        val positive = getButton(AlertDialog.BUTTON_POSITIVE)
        val negative = getButton(AlertDialog.BUTTON_NEGATIVE)

        //Disable the material spacer view in case there is one
        val parent = positive.parent as? LinearLayout
        parent?.gravity = Gravity.CENTER_HORIZONTAL
        val leftSpacer = parent?.getChildAt(1)
        leftSpacer?.visibility = View.GONE

        //Force the default buttons to center
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        layoutParams.weight = 1f
        layoutParams.gravity = Gravity.CENTER

        positive.layoutParams = layoutParams
        negative.layoutParams = layoutParams
    }

    private fun share(bitmapPath: String){
        val bitmapUri: Uri = Uri.parse(bitmapPath)

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/png"
        intent.putExtra(Intent.EXTRA_STREAM, bitmapUri)
        startActivity(Intent.createChooser(intent, "Bagikan Tanda Tangan melalui"))
    }
}
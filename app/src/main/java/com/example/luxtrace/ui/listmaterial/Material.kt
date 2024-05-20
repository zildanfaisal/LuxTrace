package com.example.luxtrace.ui.listmaterial

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Material(
    val nMaterial: String,
    val dMaterial: String,
    val pMaterial: Int
): Parcelable

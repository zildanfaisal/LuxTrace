package com.example.luxtrace.ui.listproduct

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val nProduct: String,
    val dProduct: String,
    val pProduct: Int
): Parcelable

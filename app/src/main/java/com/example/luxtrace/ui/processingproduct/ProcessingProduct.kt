package com.example.luxtrace.ui.processingproduct

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProcessingProduct(
    val nProcessingProduct: String,
    val sProcessingProduct: String,
    val dProcessingProduct: String
): Parcelable

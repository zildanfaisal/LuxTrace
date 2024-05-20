package com.example.luxtrace.ui.deliverytracking

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DeliveryTracking(
    val nDTracking: String,
    val dDTracking: String,
    val pDTracking: Int
): Parcelable

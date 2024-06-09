package com.example.luxtrace.ui.deliverytracking.detailtracking

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UpdateDeliveryTracking (
    val utDate: String,
    val utDescription: String,
    val utStatus: String
): Parcelable
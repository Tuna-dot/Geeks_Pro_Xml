package com.example.geeks_pro_xml.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val image: String,
) : Serializable, Parcelable

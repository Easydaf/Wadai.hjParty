package com.example.wadaihjparty.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Cake (
    val name: String,
    val image: Int,
    val description: String,
    val price: String,
): Parcelable

package com.developersbreach.darkthemeandroid

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Social(val icon: Int, val title: String, val subtitle: String) : Parcelable
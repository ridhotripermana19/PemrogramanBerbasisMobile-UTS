package com.tugastengahsemeter.triwiboworidhopermana.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Course(val name: String, val encounter: Int?, val dueDate: String?) : Parcelable
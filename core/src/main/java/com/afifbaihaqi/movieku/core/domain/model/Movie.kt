package com.afifbaihaqi.movieku.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var id: Int,
    var title: String,
    var poster: String,
    var release: String,
    var description: String,
    var voteAverage: Double,
    var favorite: Boolean = false
) : Parcelable
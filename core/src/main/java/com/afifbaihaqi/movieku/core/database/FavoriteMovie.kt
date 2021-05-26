package com.afifbaihaqi.movieku.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_movie")
data class FavoriteMovie(
    @PrimaryKey
    @ColumnInfo(name = "idMovie")
    var id: Int,

    @ColumnInfo(name = "titleMovie")
    var title: String,

    @ColumnInfo(name = "posterMovie")
    var poster: String,

    @ColumnInfo(name = "releaseMovie")
    var release: String,

    @ColumnInfo(name = "descriptionMovie")
    var description: String,

    @ColumnInfo(name = "voteMovie")
    var voteAverage: Double,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
) : Serializable

@Entity(tableName = "tb_tv")
data class FavoriteTv(
    @PrimaryKey
    @ColumnInfo(name = "idTv")
    var id: Int,

    @ColumnInfo(name = "titleTv")
    var title: String,

    @ColumnInfo(name = "posterTv")
    var poster: String,

    @ColumnInfo(name = "releaseTv")
    var release: String,

    @ColumnInfo(name = "descriptionTv")
    var description: String,

    @ColumnInfo(name = "voteTv")
    var voteAverage: Double,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
) : Serializable
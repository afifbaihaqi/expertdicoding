package com.afifbaihaqi.movieku.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM tb_movie")
    fun readMovie(): Flowable<List<FavoriteMovie>>

    @Query("SELECT * FROM tb_tv")
    fun readTv(): Flowable<List<FavoriteTv>>

    @Query("SELECT * FROM tb_movie WHERE tb_movie.idMovie = :id")
    fun movieDetail(id: Int): Flowable<FavoriteMovie>

    @Query("SELECT * FROM tb_tv WHERE tb_tv.idTv = :id")
    fun tvDetail(id: Int): Flowable<FavoriteTv>

    @Insert
    fun addMovie(user: List<FavoriteMovie>): Completable

    @Insert
    fun addTv(user: List<FavoriteTv>): Completable

    @Update
    fun addFavoriteMovie(user: FavoriteMovie)

    @Update
    fun addFavoriteTv(user: FavoriteTv)

    @Query("SELECT * FROM tb_movie WHERE favorite = 1")
    fun readFavoriteMovie(): Flowable<List<FavoriteMovie>>

    @Query("SELECT * FROM tb_tv WHERE favorite = 1")
    fun readFavoriteTv(): Flowable<List<FavoriteTv>>

    @Query("SELECT count(*) FROM tb_movie WHERE tb_movie.idMovie= :id AND tb_movie.favorite = 1")
    fun checkFavoriteMovie(id: Int?) : Int

    @Query("SELECT count(*) FROM tb_tv WHERE tb_tv.idTv= :id AND tb_tv.favorite = 1")
    fun checkFavoriteTv(id: Int?) : Int
}
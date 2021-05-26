package com.afifbaihaqi.movieku.core.utils

import com.afifbaihaqi.movieku.core.database.FavoriteDao
import com.afifbaihaqi.movieku.core.database.FavoriteMovie
import com.afifbaihaqi.movieku.core.database.FavoriteTv
import io.reactivex.Flowable

class LocalDataSource(private val mFavoriteDao: FavoriteDao) {

    fun readMovie(): Flowable<List<FavoriteMovie>> = mFavoriteDao.readMovie()

    fun readTv(): Flowable<List<FavoriteTv>> = mFavoriteDao.readTv()

    fun addMovie(user: List<FavoriteMovie>) = mFavoriteDao.addMovie(user)

    fun addTv(user: List<FavoriteTv>) = mFavoriteDao.addTv(user)

    fun addFavoriteMovie(user: FavoriteMovie, newState: Boolean) {
        user.favorite = newState
        mFavoriteDao.addFavoriteMovie(user)
    }

    fun addFavoriteTv(user: FavoriteTv, newState: Boolean) {
        user.favorite = newState
        mFavoriteDao.addFavoriteTv(user)
    }
    fun readFavoriteMovie(): Flowable<List<FavoriteMovie>> = mFavoriteDao.readFavoriteMovie()

    fun readFavoriteTv(): Flowable<List<FavoriteTv>> = mFavoriteDao.readFavoriteTv()

    fun checkFavoriteMovie(id: Int?) : Int = mFavoriteDao.checkFavoriteMovie(id)

    fun checkFavoriteTv(id: Int?) : Int = mFavoriteDao.checkFavoriteTv(id)

}
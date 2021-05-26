package com.afifbaihaqi.movieku.core.domain.usecase

import com.afifbaihaqi.movieku.core.vo.Resource
import com.afifbaihaqi.movieku.core.domain.model.Movie
import com.afifbaihaqi.movieku.core.domain.model.Tv
import io.reactivex.Flowable

interface MovieUseCase {
    fun getAllMovie(): Flowable<Resource<List<Movie>>>
    fun getAllTv(): Flowable<Resource<List<Tv>>>
    fun setFavoriteMovie(course: Movie, state: Boolean)
    fun setFavoriteTv(course: Tv, state: Boolean)
    fun getFavoriteMovie(): Flowable<List<Movie>>
    fun getFavoriteTv(): Flowable<List<Tv>>
    fun checkFavoriteMovie(id: Int?): Int
    fun checkFavoriteTv(id: Int?): Int
}
package com.afifbaihaqi.movieku.detail

import androidx.lifecycle.ViewModel
import com.afifbaihaqi.movieku.core.domain.model.Movie
import com.afifbaihaqi.movieku.core.domain.model.Tv
import com.afifbaihaqi.movieku.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase): ViewModel() {

    fun addFavoriteMovie(user: Movie) {
        val newState = !user.favorite
        movieUseCase.setFavoriteMovie(user, newState)
    }

    fun checkFavoriteMovie(id: Int?) : Int = movieUseCase.checkFavoriteMovie(id)

    fun addFavoriteTv(user: Tv) {
        val newState = !user.favorite
        movieUseCase.setFavoriteTv(user, newState)
    }

    fun checkFavoriteTv(id: Int?) : Int = movieUseCase.checkFavoriteTv(id)
}
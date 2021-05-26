package com.afifbaihaqi.movieku.core.domain.usecase

import com.afifbaihaqi.movieku.core.domain.model.Movie
import com.afifbaihaqi.movieku.core.domain.model.Tv
import com.afifbaihaqi.movieku.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {
    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getAllTv() = movieRepository.getAllTv()

    override fun setFavoriteMovie(course: Movie, state: Boolean) = movieRepository.setFavoriteMovie(course,state)

    override fun setFavoriteTv(course: Tv, state: Boolean) = movieRepository.setFavoriteTv(course,state)

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun getFavoriteTv() = movieRepository.getFavoriteTv()

    override fun checkFavoriteMovie(id: Int?) = movieRepository.checkFavoriteMovie(id)

    override fun checkFavoriteTv(id: Int?) = movieRepository.checkFavoriteTv(id)
}
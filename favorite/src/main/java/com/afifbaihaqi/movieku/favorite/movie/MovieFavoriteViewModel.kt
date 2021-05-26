package com.afifbaihaqi.movieku.favorite.movie

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.afifbaihaqi.movieku.core.domain.usecase.MovieUseCase

class MovieFavoriteViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val tourism = LiveDataReactiveStreams.fromPublisher(movieUseCase.getFavoriteMovie())
}
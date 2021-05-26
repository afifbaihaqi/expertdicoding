package com.afifbaihaqi.movieku.favorite.tv

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.afifbaihaqi.movieku.core.domain.usecase.MovieUseCase

class TvFavoriteViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val tourism = LiveDataReactiveStreams.fromPublisher(movieUseCase.getFavoriteTv())
}
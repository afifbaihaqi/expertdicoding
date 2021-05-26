package com.afifbaihaqi.movieku.fragment

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.afifbaihaqi.movieku.core.domain.usecase.MovieUseCase

class TvViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val tourism = LiveDataReactiveStreams.fromPublisher(movieUseCase.getAllTv())
}
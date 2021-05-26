package com.afifbaihaqi.movieku

import com.afifbaihaqi.movieku.core.domain.usecase.MovieInteractor
import com.afifbaihaqi.movieku.core.domain.usecase.MovieUseCase
import com.afifbaihaqi.movieku.detail.DetailViewModel
import com.afifbaihaqi.movieku.fragment.MovieViewModel
import com.afifbaihaqi.movieku.fragment.TvViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
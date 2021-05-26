package com.afifbaihaqi.movieku.favorite

import com.afifbaihaqi.movieku.favorite.movie.MovieFavoriteViewModel
import com.afifbaihaqi.movieku.favorite.tv.TvFavoriteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { MovieFavoriteViewModel(get()) }
    viewModel { TvFavoriteViewModel(get()) }
}
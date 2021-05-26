package com.afifbaihaqi.movieku.core.utils

import com.afifbaihaqi.movieku.core.data.MovieItem
import com.afifbaihaqi.movieku.core.data.TvItem
import com.afifbaihaqi.movieku.core.database.FavoriteMovie
import com.afifbaihaqi.movieku.core.database.FavoriteTv
import com.afifbaihaqi.movieku.core.domain.model.Movie
import com.afifbaihaqi.movieku.core.domain.model.Tv

object DataMapper {

    fun mapResponsesToLocalMovie(input: List<MovieItem>): List<FavoriteMovie> {
        val tourismList = ArrayList<FavoriteMovie>()
        input.map {
            val tourism = FavoriteMovie(
                id = it.id,
                title = it.title,
                poster = it.posterPath,
                release = it.releaseDate,
                description = it.overview,
                voteAverage = it.voteAverage,
                favorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapLocalToDomainMovie(input: List<FavoriteMovie>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                poster = it.poster,
                release = it.release,
                description = it.description,
                voteAverage = it.voteAverage,
                favorite = it.favorite
            )
        }

    fun mapDomainToLocalMovie(input: Movie) = FavoriteMovie(
        id = input.id,
        title = input.title,
        poster = input.poster,
        release = input.release,
        description = input.description,
        voteAverage = input.voteAverage,
        favorite = input.favorite
    )

    fun mapResponsesToLocalTv(input: List<TvItem>): List<FavoriteTv> {
        val tourismList = ArrayList<FavoriteTv>()
        input.map {
            val tourism = FavoriteTv(
                id = it.id,
                title = it.name,
                poster = it.posterPath,
                release = it.firstAirDate,
                description = it.overview,
                voteAverage = it.voteAverage,
                favorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapLocalToDomainTv(input: List<FavoriteTv>): List<Tv> =
        input.map {
            Tv(
                id = it.id,
                title = it.title,
                poster = it.poster,
                release = it.release,
                description = it.description,
                voteAverage = it.voteAverage,
                favorite = it.favorite
            )
        }

    fun mapDomainToLocalTv(input: Tv) = FavoriteTv(
        id = input.id,
        title = input.title,
        poster = input.poster,
        release = input.release,
        description = input.description,
        voteAverage = input.voteAverage,
        favorite = input.favorite
    )

    fun mapDetailMovie(input: FavoriteMovie) = Movie(
        id = input.id,
        title = input.title,
        poster = input.poster,
        release = input.release,
        description = input.description,
        voteAverage = input.voteAverage,
        favorite = input.favorite
    )

    fun mapDetailTv(input: FavoriteTv) = Tv(
        id = input.id,
        title = input.title,
        poster = input.poster,
        release = input.release,
        description = input.description,
        voteAverage = input.voteAverage,
        favorite = input.favorite
    )
}
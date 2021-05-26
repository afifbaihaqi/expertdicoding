package com.afifbaihaqi.movieku.core.data

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMovie(
        @Query("api_key") apiKey: String = "f40094224e55d3fd5c20321b020489ab",
        @Query("page") page: String = "1"
    ): Flowable<MovieResponse<MovieItem>>

    @GET("tv/popular")
    fun getTv(
        @Query("api_key") apiKey: String = "f40094224e55d3fd5c20321b020489ab",
        @Query("page") page: String = "1"
    ): Flowable<TvResponse<TvItem>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = "f40094224e55d3fd5c20321b020489ab"
    ) : MovieItem

    @GET("tv/{tv_id}")
    fun getDetailTv(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = "f40094224e55d3fd5c20321b020489ab"
    ) : TvItem
}
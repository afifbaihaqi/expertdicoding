package com.afifbaihaqi.movieku.core.data

import com.google.gson.annotations.SerializedName

data class MovieResponse<T>(
	@SerializedName("results")
	val results: List<T>
)

data class MovieItem(
	@SerializedName("id")
	val id: Int,

	@SerializedName("title")
	val title: String,

	@SerializedName("poster_path")
	val posterPath: String,

	@SerializedName("overview")
	val overview: String,

	@SerializedName("release_date")
	val releaseDate: String,

	@SerializedName("vote_average")
	val voteAverage: Double

)


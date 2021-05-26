package com.afifbaihaqi.movieku.core.data

import com.google.gson.annotations.SerializedName

data class TvResponse<T>(

	@field:SerializedName("results")
	val results: List<T>
)

data class TvItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double,


)

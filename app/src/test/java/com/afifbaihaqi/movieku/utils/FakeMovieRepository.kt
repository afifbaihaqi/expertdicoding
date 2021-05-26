package com.afifbaihaqi.movieku.utils

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.afifbaihaqi.movieku.core.vo.Resource
import com.afifbaihaqi.movieku.core.utils.AppExecutors
import com.afifbaihaqi.movieku.core.utils.LocalDataSource
import com.afifbaihaqi.movieku.core.utils.NetworkBoundResource
import com.afifbaihaqi.movieku.core.utils.RemoteDataSource
import com.afifbaihaqi.movieku.core.data.*
import com.afifbaihaqi.movieku.core.database.FavoriteMovie
import com.afifbaihaqi.movieku.core.database.FavoriteTv

class FakeMovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieDataSource {

    override fun getAllMovie(): LiveData<Resource<PagedList<FavoriteMovie>>> {
        return object :
            NetworkBoundResource<PagedList<FavoriteMovie>, List<MovieItem>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<FavoriteMovie>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(3)
                    .setPageSize(3)
                    .build()
                return LivePagedListBuilder(localDataSource.readMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<FavoriteMovie>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieItem>>> =
                remoteDataSource.getAllMovie()

            public override fun saveCallResult(movieResponse: List<MovieItem>) {
                val movieList = ArrayList<FavoriteMovie>()
                for (response in movieResponse) {
                    val movie = FavoriteMovie(
                        response.id,
                        response.title,
                        response.posterPath,
                        response.releaseDate,
                        response.overview,
                        response.voteAverage
                    )
                    movieList.add(movie)
                }
                localDataSource.addMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTv(): LiveData<Resource<PagedList<FavoriteTv>>> {
        return object :
            NetworkBoundResource<PagedList<FavoriteTv>, List<TvItem>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<FavoriteTv>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(3)
                    .setPageSize(3)
                    .build()
                return LivePagedListBuilder(localDataSource.readTv(), config).build()
            }

            override fun shouldFetch(data: PagedList<FavoriteTv>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvItem>>> =
                remoteDataSource.getAllTv()

            public override fun saveCallResult(movieResponse: List<TvItem>) {
                val movieList = ArrayList<FavoriteTv>()
                for (response in movieResponse) {

                    val movie = FavoriteTv(
                        response.id,
                        response.name,
                        response.posterPath,
                        response.firstAirDate,
                        response.overview,
                        response.voteAverage
                    )
                    movieList.add(movie)

                }
                localDataSource.addTv(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(movieId: Int): LiveData<Resource<FavoriteMovie>> {
        return object : NetworkBoundResource<FavoriteMovie, MovieItem>(appExecutors) {
            override fun loadFromDB(): LiveData<FavoriteMovie> =
                localDataSource.movieDetail(movieId)

            override fun shouldFetch(data: FavoriteMovie?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<MovieItem>> =
                remoteDataSource.getMovieDetail(movieId)

            override fun saveCallResult(movieResponse: MovieItem) {
                val movieList = ArrayList<FavoriteMovie>()
                val movie = FavoriteMovie(
                    movieResponse.id,
                    movieResponse.title,
                    movieResponse.posterPath,
                    movieResponse.releaseDate,
                    movieResponse.overview,
                    movieResponse.voteAverage
                )
                movieList.add(movie)

                localDataSource.addMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getTvDetail(tvShowId: Int): LiveData<Resource<FavoriteTv>> {
        return object : NetworkBoundResource<FavoriteTv, TvItem>(appExecutors) {
            override fun loadFromDB(): LiveData<FavoriteTv> =
                localDataSource.tvDetail(tvShowId)

            override fun shouldFetch(data: FavoriteTv?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<TvItem>> =
                remoteDataSource.getTvDetail(tvShowId)

            override fun saveCallResult(movieResponse: TvItem) {
                val movieList = ArrayList<FavoriteTv>()
                val movie = FavoriteTv(
                    movieResponse.id,
                    movieResponse.name,
                    movieResponse.posterPath,
                    movieResponse.firstAirDate,
                    movieResponse.overview,
                    movieResponse.voteAverage
                )
                movieList.add(movie)

                localDataSource.addTv(movieList)
            }
        }.asLiveData()
    }

    override fun setFavoriteMovie(course: FavoriteMovie, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.addFavoriteMovie(course, state) }

    override fun setFavoriteTv(course: FavoriteTv, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.addFavoriteTv(course, state) }

    override fun getFavoriteMovie(): LiveData<PagedList<FavoriteMovie>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(3)
            .setPageSize(3)
            .build()
        return LivePagedListBuilder(localDataSource.readFavoriteMovie(), config).build()
    }

    override fun getFavoriteTv(): LiveData<PagedList<FavoriteTv>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(3)
            .setPageSize(3)
            .build()
        return LivePagedListBuilder(localDataSource.readFavoriteTv(), config).build()
    }

    override fun checkFavoriteMovie(id: Int?): Int = localDataSource.checkFavoriteMovie(id)

    override fun checkFavoriteTv(id: Int?): Int = localDataSource.checkFavoriteTv(id)

}
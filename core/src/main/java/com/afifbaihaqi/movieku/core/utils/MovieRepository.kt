package com.afifbaihaqi.movieku.core.utils

import com.afifbaihaqi.movieku.core.data.ApiResponse
import com.afifbaihaqi.movieku.core.data.MovieItem
import com.afifbaihaqi.movieku.core.data.TvItem
import com.afifbaihaqi.movieku.core.domain.model.Movie
import com.afifbaihaqi.movieku.core.domain.model.Tv
import com.afifbaihaqi.movieku.core.domain.repository.IMovieRepository
import com.afifbaihaqi.movieku.core.vo.Resource
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllMovie(): Flowable<Resource<List<Movie>>> {
        return object :
            NetworkBoundResource<List<Movie>, List<MovieItem>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Movie>> {
                return localDataSource.readMovie().map {
                    DataMapper.mapLocalToDomainMovie(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): Flowable<ApiResponse<List<MovieItem>>> =
                remoteDataSource.getAllMovie()

            override fun saveCallResult(data: List<MovieItem>) {
                val tourismList = DataMapper.mapResponsesToLocalMovie(data)
                localDataSource.addMovie(tourismList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()
    }

    override fun getAllTv(): Flowable<Resource<List<Tv>>> {
        return object :
            NetworkBoundResource<List<Tv>, List<TvItem>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Tv>> {
                return localDataSource.readTv().map {
                    DataMapper.mapLocalToDomainTv(it)
                }
            }


            override fun shouldFetch(data: List<Tv>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): Flowable<ApiResponse<List<TvItem>>> =
                remoteDataSource.getAllTv()

            public override fun saveCallResult(movieResponse: List<TvItem>) {
                val tourismList = DataMapper.mapResponsesToLocalTv(movieResponse)
                localDataSource.addTv(tourismList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()
    }

    override fun setFavoriteMovie(course: Movie, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToLocalMovie(course)
        appExecutors.diskIO().execute { localDataSource.addFavoriteMovie(tourismEntity, state) }
    }

    override fun setFavoriteTv(course: Tv, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToLocalTv(course)
        appExecutors.diskIO().execute { localDataSource.addFavoriteTv(tourismEntity, state) }
    }

    override fun getFavoriteMovie(): Flowable<List<Movie>> {
        return localDataSource.readFavoriteMovie().map {
            DataMapper.mapLocalToDomainMovie(it)
        }
    }

    override fun getFavoriteTv(): Flowable<List<Tv>> {
        return localDataSource.readFavoriteTv().map {
            DataMapper.mapLocalToDomainTv(it)
        }
    }

    override fun checkFavoriteMovie(id: Int?): Int = localDataSource.checkFavoriteMovie(id)

    override fun checkFavoriteTv(id: Int?): Int = localDataSource.checkFavoriteTv(id)

}
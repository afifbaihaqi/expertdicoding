package com.afifbaihaqi.movieku.core.utils

import android.util.Log
import com.afifbaihaqi.movieku.core.data.ApiResponse
import com.afifbaihaqi.movieku.core.data.ApiService
import com.afifbaihaqi.movieku.core.data.MovieItem
import com.afifbaihaqi.movieku.core.data.TvItem
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class RemoteDataSource(private val apiService: ApiService) {

    fun getAllMovie(
    ): Flowable<ApiResponse<List<MovieItem>>> {
        EspressoIdlingResource.increment()
        val resultMovie = PublishSubject.create<ApiResponse<List<MovieItem>>>()
        val client = apiService.getMovie()
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                val dataArray = response.results
                resultMovie.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultMovie.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })
        EspressoIdlingResource.decrement()
        return resultMovie.toFlowable(BackpressureStrategy.BUFFER)

    }

    fun getAllTv(
    ): Flowable<ApiResponse<List<TvItem>>> {
        EspressoIdlingResource.increment()
        val resultMovie = PublishSubject.create<ApiResponse<List<TvItem>>>()
        val client = apiService.getTv()
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                val dataArray = response.results
                resultMovie.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultMovie.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })
        EspressoIdlingResource.decrement()
        return resultMovie.toFlowable(BackpressureStrategy.BUFFER)
    }
}
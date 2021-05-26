package com.afifbaihaqi.movieku.core.di

import androidx.room.Room
import com.afifbaihaqi.movieku.core.data.ApiService
import com.afifbaihaqi.movieku.core.domain.repository.IMovieRepository
import com.afifbaihaqi.movieku.core.database.DatabaseFavorite
import com.afifbaihaqi.movieku.core.utils.AppExecutors
import com.afifbaihaqi.movieku.core.utils.LocalDataSource
import com.afifbaihaqi.movieku.core.utils.MovieRepository
import com.afifbaihaqi.movieku.core.utils.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

val databaseModule = module {
    factory { get<DatabaseFavorite>().favoriteDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            DatabaseFavorite::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMovieRepository> { MovieRepository(get(), get(), get()) }
}
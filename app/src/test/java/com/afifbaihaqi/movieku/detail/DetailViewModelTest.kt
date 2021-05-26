package com.afifbaihaqi.movieku.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.afifbaihaqi.movieku.core.vo.Resource
import com.afifbaihaqi.movieku.core.data.DataDummy
import com.afifbaihaqi.movieku.core.database.FavoriteMovie
import com.afifbaihaqi.movieku.core.database.FavoriteTv
import com.afifbaihaqi.movieku.core.utils.MovieRepository
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private val dummyMovies = DataDummy.generateDummyMovieTest()[0]
    private val movieId = dummyMovies.id
    private val dummyTvShows = DataDummy.generateDummyTvTest()[0]
    private val tvShowId = dummyTvShows.id

    private lateinit var viewModel: DetailViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<FavoriteMovie>>

    @Mock
    private lateinit var observerTv: Observer<Resource<FavoriteTv>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogRepository)
        catalogRepository.setFavoriteTv(dummyTvShows, true)
        catalogRepository.setFavoriteMovie(dummyMovies, true)
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = Resource.success(DataDummy.generateDummyMovieDetail())
        val course = MutableLiveData<Resource<FavoriteMovie>>()
        course.value = dummyMovie

        Mockito.`when`(catalogRepository.getMovieDetail(movieId)).thenReturn(course)

        val movieData = viewModel.getMovieDetail(movieId).value?.data as FavoriteMovie

        Assert.assertNotNull(movieData)
        assertEquals(dummyMovie.data?.id, movieData.id)
        assertEquals(dummyMovie.data?.title, movieData.title)
        assertEquals(dummyMovie.data?.description, movieData.description)
        assertEquals(dummyMovie.data?.poster, movieData.poster)
        assertEquals(dummyMovie.data?.release, movieData.release)

        viewModel.getMovieDetail(movieId).observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)

    }

    @Test
    fun getTvShowDetail() {
        val dummyTvShow = Resource.success(DataDummy.generateDummyTvDetail())
        val course = MutableLiveData<Resource<FavoriteTv>>()
        course.value = dummyTvShow

        Mockito.`when`(catalogRepository.getTvDetail(tvShowId)).thenReturn(course)

        val tvShowData = viewModel.getTvDetail(tvShowId).value?.data as FavoriteTv

        Assert.assertNotNull(tvShowData)
        assertEquals(dummyTvShow.data?.id, tvShowData.id)
        assertEquals(dummyTvShow.data?.title, tvShowData.title)
        assertEquals(dummyTvShow.data?.description, tvShowData.description)
        assertEquals(dummyTvShow.data?.poster, tvShowData.poster)
        assertEquals(dummyTvShow.data?.release, tvShowData.release)

        viewModel.getTvDetail(tvShowId).observeForever(observerTv)
        verify(observerTv).onChanged(dummyTvShow)
    }

    @Test
    fun addFavoriteMovie() {
        verify(catalogRepository).setFavoriteMovie(dummyMovies,true)
    }

    @Test
    fun addFavoriteTv() {
        verify(catalogRepository).setFavoriteTv(dummyTvShows,true)
    }
}
package com.afifbaihaqi.movieku.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.afifbaihaqi.movieku.core.database.FavoriteMovie
import com.afifbaihaqi.movieku.core.utils.MovieRepository
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieFavoriteViewModelTest {
    private lateinit var viewModel: MovieFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<FavoriteMovie>>

    @Mock
    private lateinit var pagedList: PagedList<FavoriteMovie>

    @Before
    fun setUp() {
        viewModel = MovieFavoriteViewModel(movieRepository)
    }

    @Test
    fun testGetFavoriteMovie() {
        val dummyCourses = pagedList
        Mockito.`when`(dummyCourses.size).thenReturn(3)

        val movie = MutableLiveData<PagedList<FavoriteMovie>>()
        movie.value = dummyCourses

        Mockito.`when`(movieRepository.getFavoriteMovie()).thenReturn(movie)

        val dataListMovie = viewModel.getFavoriteMovie().value

        verify(movieRepository).getFavoriteMovie()
        Assert.assertNotNull(dataListMovie)
        Assert.assertEquals(3, dataListMovie?.size)

        viewModel.getFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}
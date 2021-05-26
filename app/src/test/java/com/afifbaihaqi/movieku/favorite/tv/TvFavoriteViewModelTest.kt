package com.afifbaihaqi.movieku.favorite.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.afifbaihaqi.movieku.core.database.FavoriteTv
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
class TvFavoriteViewModelTest {
    private lateinit var viewModel: TvFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<FavoriteTv>>

    @Mock
    private lateinit var pagedList: PagedList<FavoriteTv>

    @Before
    fun setUp() {
        viewModel = TvFavoriteViewModel(movieRepository)
    }

    @Test
    fun testGetFavoriteMovie() {
        val dummyCourses = pagedList
        Mockito.`when`(dummyCourses.size).thenReturn(3)

        val movie = MutableLiveData<PagedList<FavoriteTv>>()
        movie.value = dummyCourses

        Mockito.`when`(movieRepository.getFavoriteTv()).thenReturn(movie)

        val dataListMovie = viewModel.getFavoriteTv().value

        verify(movieRepository).getFavoriteTv()
        Assert.assertNotNull(dataListMovie)
        Assert.assertEquals(3, dataListMovie?.size)

        viewModel.getFavoriteTv().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}
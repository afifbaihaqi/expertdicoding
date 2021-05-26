package com.afifbaihaqi.movieku.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.afifbaihaqi.movieku.core.vo.Resource
import com.afifbaihaqi.movieku.core.database.FavoriteMovie
import com.afifbaihaqi.movieku.core.utils.MovieRepository
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<FavoriteMovie>>>

    @Mock
    private lateinit var pagedList: PagedList<FavoriteMovie>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getListMovies() {
        val dummyCourses = Resource.success(pagedList)
        `when`(dummyCourses.data?.size).thenReturn(10)

        val movie = MutableLiveData<Resource<PagedList<FavoriteMovie>>>()
        movie.value = dummyCourses

        `when`(movieRepository.getAllMovie()).thenReturn(movie)

        val dataListMovie = viewModel.getMovie().value?.data

        verify(movieRepository).getAllMovie()
        Assert.assertNotNull(dataListMovie)
        Assert.assertEquals(10, dataListMovie?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}
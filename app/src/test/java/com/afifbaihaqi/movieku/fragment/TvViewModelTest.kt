package com.afifbaihaqi.movieku.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.afifbaihaqi.movieku.core.vo.Resource
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
class TvViewModelTest {

    private lateinit var viewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<FavoriteTv>>>

    @Mock
    private lateinit var pagedList: PagedList<FavoriteTv>

    @Before
    fun setUp() {
        viewModel = TvViewModel(movieRepository)
    }
    @Test
    fun getListOnTheAirTvShows() {
        val dummyCourses = Resource.success(pagedList)
        Mockito.`when`(dummyCourses.data?.size).thenReturn(10)

        val tvShow = MutableLiveData<Resource<PagedList<FavoriteTv>>>()
        tvShow.value = dummyCourses

        Mockito.`when`(movieRepository.getAllTv()).thenReturn(tvShow)

        val dataListTvShow = viewModel.getTv().value?.data

        verify(movieRepository).getAllTv()
        Assert.assertNotNull(dataListTvShow)
        Assert.assertEquals(10, dataListTvShow?.size)

        viewModel.getTv().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}
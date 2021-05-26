package com.afifbaihaqi.movieku.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.afifbaihaqi.movieku.core.vo.Resource
import com.afifbaihaqi.movieku.core.utils.AppExecutors
import com.afifbaihaqi.movieku.core.utils.LocalDataSource
import com.afifbaihaqi.movieku.core.utils.RemoteDataSource
import com.afifbaihaqi.movieku.core.data.DataDummy
import com.afifbaihaqi.movieku.core.database.FavoriteMovie
import com.afifbaihaqi.movieku.core.database.FavoriteTv
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.mock


class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val testExecutors = AppExecutors(
        AppExecutorsTest(),
        AppExecutorsTest(),
        AppExecutorsTest()
    )

    private val catalogRepository = FakeMovieRepository(remote, local, appExecutors)

    private val listMovieResponse = DataDummy.generateDummyMovieTest()
    private val movieId = listMovieResponse[0].id
    private val listTvShowResponse = DataDummy.generateDummyTvTest()
    private val tvShowId = listTvShowResponse[0].id
    private val movieResponse = DataDummy.generateDummyMovieTest()[0]
    private val tvShowResponse = DataDummy.generateDummyTvTest()[0]

    @Test
    fun getMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteMovie>
        `when`(local.readMovie()).thenReturn(dataSourceFactory)
        catalogRepository.getAllMovie()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovieTest()))
        verify(local).readMovie()
        assertNotNull(courseEntities.data)
        assertEquals(listMovieResponse.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyCourses = MutableLiveData<FavoriteMovie>()
        dummyCourses.value = movieResponse
        `when`(local.movieDetail(movieId)).thenReturn(dummyCourses)

        val courseEntities = LiveDataTestUtil.getValue(catalogRepository.getMovieDetail(movieId))
        verify(local).movieDetail(movieId)
        Assert.assertNotNull(courseEntities.data)
        assertEquals(movieResponse.id, courseEntities.data?.id)
    }

    @Test
    fun getTvShowOnTheAir() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteTv>
        `when`(local.readTv()).thenReturn(dataSourceFactory)
        catalogRepository.getAllTv()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvTest()))
        verify(local).readTv()
        assertNotNull(courseEntities.data)
        assertEquals(listTvShowResponse.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        val dummyCourses = MutableLiveData<FavoriteTv>()
        dummyCourses.value = tvShowResponse
        `when`(local.tvDetail(tvShowId)).thenReturn(dummyCourses)

        val courseEntities = LiveDataTestUtil.getValue(catalogRepository.getTvDetail(tvShowId))
        verify(local).tvDetail(tvShowId)
        Assert.assertNotNull(courseEntities.data)
        assertEquals(tvShowResponse.id, courseEntities.data?.id)
    }

    @Test
    fun getListFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteMovie>
        `when`(local.readFavoriteMovie()).thenReturn(dataSourceFactory)
        catalogRepository.getFavoriteMovie()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovieTest()))
        Mockito.verify(local).readFavoriteMovie()
        org.junit.Assert.assertNotNull(movieEntity.data)
        assertEquals(listMovieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getListFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteTv>
        `when`(local.readFavoriteTv()).thenReturn(dataSourceFactory)
        catalogRepository.getFavoriteTv()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvTest()))
        Mockito.verify(local).readFavoriteTv()
        org.junit.Assert.assertNotNull(tvShowEntity.data)
        assertEquals(listTvShowResponse.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        val newState = !movieResponse.favorite
        `when` (appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when` (local).addFavoriteMovie(movieResponse, newState)

        catalogRepository.setFavoriteMovie(movieResponse, newState)
        verify(local, times(1)).addFavoriteMovie(movieResponse,newState)
    }

    @Test
    fun setFavoriteTv() {
        val newState = !tvShowResponse.favorite

        `when` (appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when` (local).addFavoriteTv(tvShowResponse, newState)

        catalogRepository.setFavoriteTv(tvShowResponse, newState)
        verify(local, times(1)).addFavoriteTv(tvShowResponse,newState)
    }
}
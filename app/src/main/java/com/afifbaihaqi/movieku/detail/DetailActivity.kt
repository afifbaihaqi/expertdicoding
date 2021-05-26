package com.afifbaihaqi.movieku.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.afifbaihaqi.movieku.databinding.ActivityDetailBinding
import com.afifbaihaqi.movieku.core.domain.model.Movie
import com.afifbaihaqi.movieku.core.domain.model.Tv
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModel()

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_CODE = "extra_code"
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.getIntExtra(EXTRA_ID, 0)
        val code = intent.getIntExtra(EXTRA_CODE, 0)
        if (code == 1) {
            val detail = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
            Log.d("cuk",detail.toString())
            showDetailMovie(detail)
            setFavoriteMovie(detailViewModel, detail)

        } else {
            val detail = intent.getParcelableExtra<Tv>(EXTRA_TV)
            showDetailTv(detail)
            setFavoriteTv(detailViewModel, detail)
        }
    }

    private fun showDetailMovie(movies: Movie?) {
        movies.let {
            binding.title.text = it?.title
            binding.genre.text = it?.voteAverage.toString()
            binding.release.text = it?.release
            binding.tvDesc.text = it?.description
            Glide.with(this@DetailActivity)
                .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${it?.poster}")
                .apply(RequestOptions().override(200, 280))
                .into(binding.imageView)
        }
    }

    private fun showDetailTv(tv: Tv?) {
        tv.let {
            binding.title.text = tv?.title
            binding.genre.text = tv?.voteAverage.toString()
            binding.release.text = tv?.release
            binding.tvDesc.text = tv?.description
            Glide.with(this@DetailActivity)
                .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${tv?.poster}")
                .apply(RequestOptions().override(200, 280))
                .into(binding.imageView)


        }
    }

    private fun setFavoriteMovie(viewModel: DetailViewModel, movieId: Movie?) {
        var _isChecked = false
        CoroutineScope(Dispatchers.IO).launch {
            val count = viewModel.checkFavoriteMovie(movieId?.id)
            withContext(Dispatchers.Main) {
                if (count != null) {
                    if (count > 0) {
                        binding.toggleFavorite.isChecked = true
                        _isChecked = true
                    } else {
                        binding.toggleFavorite.isChecked = false
                        _isChecked = false
                    }
                }
            }
        }

        binding.toggleFavorite.setOnClickListener {
            _isChecked = !_isChecked
            viewModel.addFavoriteMovie(movieId!!)
            binding.toggleFavorite.isChecked = _isChecked
        }
    }

    private fun setFavoriteTv(viewModel: DetailViewModel, data: Tv?) {
        var _isChecked = false
        CoroutineScope(Dispatchers.IO).launch {
            val count = viewModel.checkFavoriteTv(data?.id)
            withContext(Dispatchers.Main) {
                if (count != null) {
                    if (count > 0) {
                        binding.toggleFavorite.isChecked = true
                        _isChecked = true
                    } else {
                        binding.toggleFavorite.isChecked = false
                        _isChecked = false
                    }
                }
            }
        }

        binding.toggleFavorite.setOnClickListener {
            _isChecked = !_isChecked
            viewModel.addFavoriteTv(data!!)
            binding.toggleFavorite.isChecked = _isChecked
        }
    }
}
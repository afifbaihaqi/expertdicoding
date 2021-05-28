package com.afifbaihaqi.movieku.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.afifbaihaqi.movieku.core.adapter.MovieFavoriteAdapter
import org.koin.android.viewmodel.ext.android.viewModel
import com.afifbaihaqi.movieku.detail.DetailActivity
import com.afifbaihaqi.movieku.core.domain.model.Movie
import com.afifbaihaqi.movieku.favorite.databinding.FragmentMovieFavoriteBinding
import com.afifbaihaqi.movieku.favorite.favoriteModule
import org.koin.core.context.loadKoinModules

class MovieFavoriteFragment : Fragment() {
    private lateinit var binding: FragmentMovieFavoriteBinding
    private val movieViewModel: MovieFavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            loadKoinModules(favoriteModule)
            val adapter = MovieFavoriteAdapter()


            adapter.setOnItemClickCallback(object : MovieFavoriteAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Movie) {
                    val kirimData = Intent(activity, DetailActivity::class.java)
                    Log.d("cik",data.toString())
                    kirimData.putExtra(DetailActivity.EXTRA_CODE, 1)
                    kirimData.putExtra(DetailActivity.EXTRA_MOVIE, data)
                    startActivity(kirimData)
                }
            })

            movieViewModel.tourism.observe(this, {
                binding.progressBar.visibility = View.VISIBLE
                adapter.setCourses(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            })

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
}
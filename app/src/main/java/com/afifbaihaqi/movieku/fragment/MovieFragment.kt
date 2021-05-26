package com.afifbaihaqi.movieku.fragment


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.afifbaihaqi.movieku.core.vo.Status
import com.afifbaihaqi.movieku.core.adapter.MovieAdapter
import com.afifbaihaqi.movieku.databinding.FragmentMovieBinding
import com.afifbaihaqi.movieku.detail.DetailActivity
import com.afifbaihaqi.movieku.core.domain.model.Movie
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val adapter = MovieAdapter()
            adapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Movie) {
                    val kirimData = Intent(activity, DetailActivity::class.java)
                    Log.d("cik",data.toString())
                    kirimData.putExtra(DetailActivity.EXTRA_CODE, 1)
                    kirimData.putExtra(DetailActivity.EXTRA_MOVIE, data)
                    startActivity(kirimData)
                }
            })

            movieViewModel.tourism.observe(this, {
                if (it != null) {
                    when (it.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            adapter.setCourses(it.data)
                            adapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })



            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
}
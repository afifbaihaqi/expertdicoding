package com.afifbaihaqi.movieku.favorite.tv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.afifbaihaqi.movieku.core.adapter.TvFavoriteAdapter
import org.koin.android.viewmodel.ext.android.viewModel
import com.afifbaihaqi.movieku.detail.DetailActivity
import com.afifbaihaqi.movieku.core.domain.model.Tv
import com.afifbaihaqi.movieku.favorite.databinding.FragmentTvFavoriteBinding
import com.afifbaihaqi.movieku.favorite.favoriteModule
import org.koin.core.context.loadKoinModules


class TvFavoriteFragment : Fragment() {
    private lateinit var binding: FragmentTvFavoriteBinding
    private val tvViewModel: TvFavoriteViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            loadKoinModules(favoriteModule)

            val adapter = TvFavoriteAdapter()
            adapter.setOnItemClickCallback(object : TvFavoriteAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Tv) {
                    val kirimData = Intent(activity, DetailActivity::class.java)
                    Log.d("cik",data.toString())
                    kirimData.putExtra(DetailActivity.EXTRA_CODE, 0)
                    kirimData.putExtra(DetailActivity.EXTRA_TV, data)
                    startActivity(kirimData)
                }
            })

            tvViewModel.tourism.observe(this,{
                adapter.setCourses(it)
                adapter.notifyDataSetChanged()
            })

            with(binding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
}
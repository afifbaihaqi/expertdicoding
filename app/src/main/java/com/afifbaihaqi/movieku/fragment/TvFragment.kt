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
import com.afifbaihaqi.movieku.core.adapter.TvAdapter
import org.koin.android.viewmodel.ext.android.viewModel
import com.afifbaihaqi.movieku.databinding.FragmentTvBinding
import com.afifbaihaqi.movieku.detail.DetailActivity
import com.afifbaihaqi.movieku.core.domain.model.Tv

class TvFragment : Fragment() {
    private lateinit var binding: FragmentTvBinding
    private val tvViewModel: TvViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {


            val adapter = TvAdapter()
            adapter.setOnItemClickCallback(object : TvAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Tv) {
                    val kirimData = Intent(activity, DetailActivity::class.java)
                    Log.d("cik",data.toString())
                    kirimData.putExtra(DetailActivity.EXTRA_CODE, 0)
                    kirimData.putExtra(DetailActivity.EXTRA_TV, data)
                    startActivity(kirimData)
                }
            })

            tvViewModel.tourism.observe(this,{
                if(it != null){
                    when(it.status){
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

            with(binding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
}
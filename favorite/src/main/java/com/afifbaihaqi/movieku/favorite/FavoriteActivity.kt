package com.afifbaihaqi.movieku.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afifbaihaqi.movieku.favorite.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sectionsPagerAdapter = FavoritePagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        supportActionBar?.elevation = 0f
    }
}
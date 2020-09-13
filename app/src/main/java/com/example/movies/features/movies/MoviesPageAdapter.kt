package com.example.movies.features.movies

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movies.features.movies.MoviesFragment
import com.example.movies.model.MovieGenre

class MoviesPageAdapter(manager: FragmentActivity, val movieGenres:Array<MovieGenre> ) : FragmentStateAdapter(manager) {

    override fun getItemCount(): Int {
        return movieGenres.size
    }

    override fun createFragment(position: Int): Fragment {
        return MoviesFragment.newInstance(movieGenres[position])
    }
}
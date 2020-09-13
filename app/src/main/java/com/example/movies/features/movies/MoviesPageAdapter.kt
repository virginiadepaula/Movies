package com.example.movies.features.movies

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movies.features.movies.MoviesFragment

class MoviesPageAdapter(manager: FragmentActivity, val itemTitle:Array<String> ) : FragmentStateAdapter(manager) {


    override fun getItemCount(): Int {
        return itemTitle.size
    }

    override fun createFragment(position: Int): Fragment {
        return MoviesFragment.newInstance(position)
    }

    fun getPageTitle(position: Int): CharSequence? {
        return itemTitle.get(position)
    }
}
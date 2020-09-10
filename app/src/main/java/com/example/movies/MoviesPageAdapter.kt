package com.example.movies

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

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
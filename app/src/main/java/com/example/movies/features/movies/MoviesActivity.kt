package com.example.movies.features.movies

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.movies.*
import com.example.movies.features.details.MovieDetailsActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviesActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  toolbarMain.title = getString(R.string.movie_title)
       // setSupportActionBar(toolbarMain)

        supportActionBar?.elevation = 0f

        val titulosTab = resources.getStringArray(R.array.titulos_tab)

        val tabLayout:TabLayout = findViewById(R.id.tabLayout)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)

        val moviesAdapter = MoviesPageAdapter(this, titulosTab)
        viewPager.adapter = moviesAdapter

        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            tab.text = titulosTab[position]
        }.attach()

    }
}






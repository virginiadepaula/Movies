package com.example.movies.features.movies

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.movies.*
import com.example.movies.features.details.MovieDetailsActivity
import com.example.movies.features.searchmovies.SearchActivity
import com.example.movies.model.Movie
import com.example.movies.model.MovieGenre
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviesActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarMain.title = getString(R.string.movie_title)
        setSupportActionBar(toolbarMain)
        supportActionBar?.elevation = 0f

        val titulosTab = resources.getStringArray(R.array.titulos_tab)

        val tabLayout:TabLayout = findViewById(R.id.tabLayout)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)


        val moviesAdapter = MoviesPageAdapter(this, arrayOf(MovieGenre.Action,MovieGenre.Drama, MovieGenre.Fantasy,MovieGenre.Fiction))
        viewPager.adapter = moviesAdapter

        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            tab.text = titulosTab[position]
        }.attach()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
       R.id.action_search -> {
           val intent = Intent(this, SearchActivity::class.java)
           this.startActivity(intent)
           true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun goToDetails(movie:Movie){
        val intent = MovieDetailsActivity.getStartIntent(this,movie)
        this.startActivity(intent)
    }
}






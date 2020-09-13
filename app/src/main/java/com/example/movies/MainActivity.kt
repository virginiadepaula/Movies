package com.example.movies

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
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

        val viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        viewModel.moviesLiveData.observe(this, Observer {
            it?.let { movies ->
                with(recyclerMovies){
                    layoutManager = GridLayoutManager(this@MainActivity, 2)
                    setHasFixedSize(true)
                    adapter = MoviesAdapter(movies){movie ->
                        val intent = DescribeActivity.getStartIntent(this@MainActivity, movie.overview, movie.poster_path)
                        this@MainActivity.startActivity(intent)
                    }
                }
            }
        })
        viewModel.getMovies()
    }
}






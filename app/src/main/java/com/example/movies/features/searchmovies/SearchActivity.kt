package com.example.movies.features.searchmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import kotlinx.android.synthetic.main.fragment_movies.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val viewModel = ViewModelProvider(this).get(SearchMoviesViewModel::class.java)

        viewModel.moviesLiveData.observe(this, Observer {
            it?.let { movies ->
                with(recyclerMovies){
                    layoutManager = LinearLayoutManager(this@SearchActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = SearchMoviesAdapter(movies)
                }
            }
        })
        viewModel.searchMovies()
    }
}
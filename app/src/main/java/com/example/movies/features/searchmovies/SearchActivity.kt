package com.example.movies.features.searchmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.features.details.MovieDetailsActivity
import com.example.movies.features.movies.MoviesActivity
import com.example.movies.features.movies.MoviesAdapter
import com.example.movies.model.Movie
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_movies.*
import java.sql.Time
import java.util.*

class SearchActivity : AppCompatActivity() {
    lateinit var viewModel: SearchMoviesViewModel
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(timer != null){
                timer?.cancel()
                timer = null
            }
            timer = object : CountDownTimer(1000, 1000) {
                override fun onFinish() {
                    viewModel.searchMovies(searchEditText.text.toString())
                }

                override fun onTick(p0: Long) {
                }
            }
            timer?.start()

        }
    }

    private var timer : CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchEditText.addTextChangedListener(textWatcher)

        recyclerSearchMovies.layoutManager = GridLayoutManager(this@SearchActivity, 2)
        recyclerSearchMovies.setHasFixedSize(true)
        recyclerSearchMovies.adapter = MoviesAdapter(emptyList<Movie>()){movie ->
            goToDetails(movie)
        }

        viewModel = ViewModelProvider(this).get(SearchMoviesViewModel::class.java)

        viewModel.moviesLiveData.observe(this, Observer {
            it?.let { movies ->
                recyclerSearchMovies.adapter = MoviesAdapter(movies){movie ->
                    goToDetails(movie)
                }
                recyclerSearchMovies.adapter?.notifyDataSetChanged()

            }
        })

    }

    fun goToDetails(movie:Movie){
        val intent = MovieDetailsActivity.getStartIntent(this,movie)
        this.startActivity(intent)
    }


}
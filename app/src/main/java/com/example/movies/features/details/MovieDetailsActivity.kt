package com.example.movies.features.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.R
import com.example.movies.imageUrl
import com.example.movies.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    lateinit var movie: Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        movie = intent.extras?.getSerializable("movie") as Movie
        overviewMovie.text = movie.overview
        Picasso.get().load(imageUrl + movie.poster_path).into(imageDescribe)
    }

    companion object{
        fun getStartIntent(context: Context, movie: Movie ):Intent{
            return Intent(context, MovieDetailsActivity::class.java).apply {
                putExtra("movie", movie)
            }
        }
    }
}
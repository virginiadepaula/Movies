package com.example.movies.features.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.R
import com.example.movies.features.movies.MoviesAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_describe.*

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_describe)

        val overview = intent.getStringExtra(EXTRA_OVERVIEW)
        val poster_path= intent.getStringExtra(EXTRA_POSTER_PATH)

        overviewMovie.text = overview
        Picasso.get().load(poster_path).into(imageDescribe)

    }

    companion object{
        private const val EXTRA_OVERVIEW = "EXTRA_OVERVIEW"
        private const val EXTRA_POSTER_PATH = "EXTRA_POSTER_PATH"

        fun getStartIntent(context: Context, overview: String, poster_path : String ):Intent{
            return Intent(context, MoviesAdapter::class.java).apply {
                putExtra(EXTRA_OVERVIEW, overview)
                putExtra(EXTRA_POSTER_PATH, poster_path)
            }
        }
    }
}
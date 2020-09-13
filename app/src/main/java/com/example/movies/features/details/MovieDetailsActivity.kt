package com.example.movies.features.details

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.R
import com.example.movies.imageUrl
import com.example.movies.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.activity_movie_details.toolbarMain

class MovieDetailsActivity : AppCompatActivity() {
    lateinit var movie: Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        movie = intent.extras?.getSerializable("movie") as Movie
        overviewMovie.text = movie.overview
        Picasso.get().load(imageUrl + movie.poster_path).into(imageDescribe)

        toolbarMain.title = movie.title
        setSupportActionBar(toolbarMain)

    }

    override fun onResume() {
        super.onResume()
        imageDescribe.post(Runnable {
            val weight: Int = imageDescribe.getWidth()
            val height: Int = (weight * 1.5).toInt()
            imageDescribe.layoutParams = LinearLayout.LayoutParams(weight, height)
        })

    }

    companion object{
        fun getStartIntent(context: Context, movie: Movie):Intent{
            return Intent(context, MovieDetailsActivity::class.java).apply {
                putExtra("movie", movie)
            }
        }
    }

    fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
}
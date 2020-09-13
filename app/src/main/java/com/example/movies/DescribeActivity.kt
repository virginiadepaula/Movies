package com.example.movies

import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_describe.*
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessControlContext

class DescribeActivity : AppCompatActivity() {
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
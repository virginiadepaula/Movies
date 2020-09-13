package com.example.movies.features.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies.R
import com.example.movies.model.Movie
import com.example.movies.model.MovieGenre
import kotlinx.android.synthetic.main.fragment_movies.*

private const val MOVIE_GENRE = "MOVIE_GENRE"

class MoviesFragment : Fragment() {
    private lateinit var movieGenre: MovieGenre
    private lateinit var moviesArray: Array<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieGenre = it.getSerializable(MOVIE_GENRE) as MovieGenre
        }
        val viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        viewModel.moviesLiveData.observe(this, Observer {
            it?.let { movies ->
                with(recyclerMovies){
                    layoutManager = GridLayoutManager(this.context, 2)
                    setHasFixedSize(true)
                    adapter = MoviesAdapter(movies){movie ->
                        //    val intent = MovieDetailsActivity.getStartIntent(this@MoviesActivity, movie.overview, movie.poster_path)
                        //      this@MoviesActivity.startActivity(intent)
                    }
                }
            }
        })
     //   viewModel.getMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: Int) =
            MoviesFragment().apply {
                arguments = Bundle().apply {
                    putInt(MOVIE_GENRE, param1)
    //                putString(ARG_PARAM2, param2)
                }
            }

    }
}
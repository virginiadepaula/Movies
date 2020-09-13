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
import com.example.movies.features.details.MovieDetailsActivity
import com.example.movies.model.Movie
import com.example.movies.model.MovieGenre
import kotlinx.android.synthetic.main.fragment_movies.*

private const val MOVIE_GENRE = "MOVIE_GENRE"

class MoviesFragment : Fragment() {
    private lateinit var movieGenre: MovieGenre
    private lateinit var moviesArray: Array<Movie>

    lateinit var viewModel : MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieGenre = it.getSerializable(MOVIE_GENRE) as MovieGenre
        }
        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        viewModel.moviesLiveData.observe(this, {
            it?.let { movies ->
                with(recyclerMovies){
                    layoutManager = GridLayoutManager(this.context, 2)
                    setHasFixedSize(true)
                    adapter = MoviesAdapter(this@MoviesFragment.activity as MoviesActivity, movies){movie ->
                        (activity as MoviesActivity).goToDetails(movie)
                    }
                }
            }
        })
        viewModel.getMovies(movieGenre)
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
        fun newInstance(movieGenre: MovieGenre) =
            MoviesFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MOVIE_GENRE, movieGenre)
                }
            }

    }
}
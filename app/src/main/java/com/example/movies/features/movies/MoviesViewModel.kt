package com.example.movies.features.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.model.Movie
import com.example.movies.model.MovieGenre
import com.example.movies.model.response.MoviesBodyResponse
import com.example.movies.model.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel: ViewModel() {
    val moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMovies(movieGenre: MovieGenre){
        ApiService.service.getMovies(movieGenre.genre).enqueue(object : Callback<MoviesBodyResponse>{
            override fun onResponse(call: Call<MoviesBodyResponse>, response: Response<MoviesBodyResponse>) {
                 if(response.isSuccessful) {
                     val movies:MutableList<Movie> = mutableListOf()

                     response.body()?.let {moviesBodyResponse ->
                         for (results in moviesBodyResponse.movieResults) {
                             val movie = Movie(
                                 title = results.title ,
                                 poster_path = results.poster_path,
                                 overview = results.overview
                             )
                            movies.add(movie)
                         }
                         moviesLiveData.value = movies
                     }
                 }
            }

            override fun onFailure(call: Call<MoviesBodyResponse>, t: Throwable) {
                Log.v("retrofit","call failed")
            }
        })
    }
}
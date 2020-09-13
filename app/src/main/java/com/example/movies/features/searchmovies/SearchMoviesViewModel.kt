package com.example.movies.features.searchmovies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.model.Movie
import com.example.movies.model.response.MoviesBodyResponse
import com.example.movies.model.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchMoviesViewModel:ViewModel() {
    val moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun searchMovies(text: String){
        ApiService.service.searchMovies(text).enqueue(object : Callback<MoviesBodyResponse> {
            override fun onResponse(call: Call<MoviesBodyResponse>, response: Response<MoviesBodyResponse>) {
                if(response.isSuccessful) {
                    val movies:MutableList<Movie> = mutableListOf()

                    response.body()?.let {searchBodyResponse ->
                        for (results in searchBodyResponse.movieResults) {
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
                Log.v("view","")
            }
        })
    }

}
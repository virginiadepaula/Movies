package com.example.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchMoviesViewModel:ViewModel() {
    val moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun searchMovies(){
        ApiService.service.searchMovies().enqueue(object : Callback<SearchMovieBodyResponse> {
            override fun onResponse(call: Call<SearchMovieBodyResponse>, response: Response<SearchMovieBodyResponse>) {
                if(response.isSuccessful) {
                    val movies:MutableList<Movie> = mutableListOf()

                    response.body()?.let {searchBodyResponse ->
                        for (results in searchBodyResponse.searchMovie) {
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

            override fun onFailure(call: Call<SearchMovieBodyResponse>, t: Throwable) {
            }
        })
    }

}
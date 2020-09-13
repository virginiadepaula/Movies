package com.example.movies.model


import com.example.movies.model.response.MoviesBodyResponse
import com.example.movies.model.response.SearchMovieBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbServices {
    @GET("discover/movie")
    fun getMovies(
        @Query("with_genres") with_genres: String,
        @Query("api_key") api_key:String = "8372bc521d62310281aea0244dd9faf8",
        @Query("language") language:String = "pt-BR"
    //,28,14,878
    ): Call<MoviesBodyResponse>

    @GET("search/movie")
    fun searchMovies(
        @Query("api_key") api_key:String = "8372bc521d62310281aea0244dd9faf8",
        @Query("language") language:String = "pt-BR",
        @Query("with_genres") with_genres:String = "busca"
    ): Call<SearchMovieBodyResponse>

}
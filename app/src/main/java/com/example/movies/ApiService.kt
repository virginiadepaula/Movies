package com.example.movies

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {
    private fun initRetrofit(): Retrofit{
       return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service:TheMovieDbServices  = initRetrofit().create(TheMovieDbServices::class.java)
}
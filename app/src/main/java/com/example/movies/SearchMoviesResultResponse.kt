package com.example.movies

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchMoviesResultResponse(
    val title:String,
    val poster_path:String,
    val overview: String
)
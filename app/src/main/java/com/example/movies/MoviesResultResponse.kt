package com.example.movies

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResultResponse (
    val title:String,
    val poster_path:String
)
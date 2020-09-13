package com.example.movies.model.response

import com.example.movies.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesBodyResponse (
    @Json(name = "results")
    val movieResults: List<Movie>
)
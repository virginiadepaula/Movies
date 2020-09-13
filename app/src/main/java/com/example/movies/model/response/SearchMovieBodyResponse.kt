package com.example.movies.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchMovieBodyResponse (
    @Json(name="results")
    val searchMovie:List<SearchMoviesResultResponse>
)
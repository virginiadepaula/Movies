package com.example.movies.model

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Movie(
    var title: String,
    var poster_path: String?,
    var overview: String
):Serializable
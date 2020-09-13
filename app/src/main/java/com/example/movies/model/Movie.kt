package com.example.movies.model

import java.io.Serializable

data class Movie(
    var title: String,
    var poster_path: String?,
    var overview: String
):Serializable
package com.example.movies.model

import androidx.annotation.Nullable

data class Movie(
    var title: String,
    var poster_path: String?,
    var overview: String
)
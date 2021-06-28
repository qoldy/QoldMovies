package com.example.qoldmovies.data

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("display_title")
        val title:String,
        @SerializedName("summary_short")
        val description:String,
        @SerializedName("multimedia")
        val movieImage: MovieImage
)

data class MovieImage(
        @SerializedName("src")
        val src:String
)

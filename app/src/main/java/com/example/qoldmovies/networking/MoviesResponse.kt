package com.example.qoldmovies.networking

import com.example.qoldmovies.data.Movie
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
        @SerializedName("status")
        val status:String,
        @SerializedName("has_more")
        val hasMore:Boolean,
        @SerializedName("num_results")
        val numResults:Int,
        @SerializedName("results")
        val result:ArrayList<Movie>
)
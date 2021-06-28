package com.example.qoldmovies.mvvm.viewmodels.contracts

import com.example.qoldmovies.data.Movie

interface MoviesContract {
    fun onResponse(movies:ArrayList<Movie>)
    fun onFullLoaded()
}
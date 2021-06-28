package com.example.qoldmovies.mvvm.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qoldmovies.data.Movie
import com.example.qoldmovies.mvvm.models.MoviesModel
import com.example.qoldmovies.mvvm.viewmodels.contracts.MoviesContract

class MoviesVM:ViewModel(), MoviesContract {
    var liveData = MutableLiveData<ArrayList<Movie>>()
    var liveHasMore=MutableLiveData<Boolean>(true)
    private var model = MoviesModel(this)
    fun getMovies(){
        if(model.hasMore)
            model.getMovies()
        else
            liveHasMore.value=false
    }

    override fun onResponse(movies: ArrayList<Movie>) {
        liveData.value=movies
    }

    override fun onFullLoaded() {
        liveHasMore.value=false
    }
}
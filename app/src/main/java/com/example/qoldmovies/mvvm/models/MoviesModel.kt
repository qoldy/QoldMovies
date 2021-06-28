package com.example.qoldmovies.mvvm.models

import android.util.Log
import com.example.qoldmovies.mvvm.viewmodels.MoviesVM
import com.example.qoldmovies.mvvm.viewmodels.contracts.MoviesContract
import com.example.qoldmovies.networking.MoviesResponse
import com.example.qoldmovies.networking.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MoviesModel(val vm: MoviesContract) {
    private var offset=0
    var hasMore=true

    fun getMovies(){
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
                RetrofitService.getInstance().getMovies(RetrofitService.API_KEY,offset)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({response->onResponse(response)},{error->{onError(error)}})
        )
    }

    private fun onError(error:Throwable){
        Log.v("not_kk", error.message.toString())
    }

    private fun onResponse(response: MoviesResponse){
        offset+=response.numResults
        hasMore=response.hasMore
        if(!response.hasMore)
            vm.onFullLoaded()
        vm.onResponse(response.result)
    }
}
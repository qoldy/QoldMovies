package com.example.qoldmovies.networking

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("all.json")
    fun getMovies(@Query("api-key")apiKey:String, @Query("offset") offset:Int): Observable<MoviesResponse>
}
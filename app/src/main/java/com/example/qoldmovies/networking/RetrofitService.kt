package com.example.qoldmovies.networking

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object{
        private const val BASE_URL:String="https://api.nytimes.com/svc/movies/v2/reviews/"
        const val API_KEY:String="KvSOp8LY77A3EGDCyWlCjeXeARoQk9UG"
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        private val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)}.build()
        val gson = GsonBuilder()
            .create()
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiInterface::class.java)

        fun getInstance():ApiInterface{
            return retrofit
        }
    }
}
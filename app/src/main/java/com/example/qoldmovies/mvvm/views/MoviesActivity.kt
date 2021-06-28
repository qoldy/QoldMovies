package com.example.qoldmovies.mvvm.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qoldmovies.R
import com.example.qoldmovies.data.Movie
import com.example.qoldmovies.mvvm.viewmodels.MoviesVM
import com.example.qoldmovies.util.MoviesAdapter
import com.example.qoldmovies.util.VMFactory

class MoviesActivity:AppCompatActivity() {
    private lateinit var moviesVM: MoviesVM

    private lateinit var moviesRecView:RecyclerView
    private lateinit var moviesAdapter:MoviesAdapter
    private lateinit var layoutManager: LinearLayoutManager

    private var isLoading=true
    private var isFullLoaded=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_activity)
        init()
    }
    private fun init(){
        moviesRecView=findViewById(R.id.list)
        moviesAdapter = MoviesAdapter(ArrayList())
        moviesRecView.adapter=moviesAdapter
        layoutManager= LinearLayoutManager(this)
        moviesRecView.layoutManager=layoutManager

        moviesRecView.addOnScrollListener(object:RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(!isLoading&&!isFullLoaded){
                    if(layoutManager.findLastVisibleItemPosition()==moviesAdapter.itemCount-1){
                        moviesVM.getMovies()
                        isLoading=true
                    }
                }
            }
        })

        val factory = VMFactory()
        val provider = ViewModelProvider(this, factory)
        moviesVM = provider.get(MoviesVM::class.java)
        observeData()

        moviesVM.getMovies()
    }

    private fun observeData(){
        moviesVM.liveData.observe(this, Observer {
            moviesVM.liveData.value?.let { it1 -> moviesAdapter.addMovies(it1) }
            moviesAdapter.notifyDataSetChanged()
            isLoading=false
        })
        moviesVM.liveHasMore.observe(this, Observer {
            isFullLoaded=!moviesVM.liveHasMore.value!!
        })
    }
}
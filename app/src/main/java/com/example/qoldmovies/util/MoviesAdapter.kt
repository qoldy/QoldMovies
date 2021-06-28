package com.example.qoldmovies.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qoldmovies.R
import com.example.qoldmovies.data.Movie
import com.squareup.picasso.Picasso

class MoviesAdapter(private val movies:ArrayList<Movie>):RecyclerView.Adapter<MoviesAdapter.Holder>() {
    class Holder(item: View):RecyclerView.ViewHolder(item){
        var titleTextView:TextView?=null
        var descriptionTextView:TextView?=null
        var imageView: ImageView?=null
        init{
            titleTextView=item.findViewById(R.id.title)
            descriptionTextView=item.findViewById(R.id.description)
            imageView=item.findViewById(R.id.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val item = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_list_item, parent, false)
        return Holder(item)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.titleTextView?.text=movies[position].title
        holder.descriptionTextView?.text=movies[position].description
        Picasso.get()
                .load(movies[position].movieImage.src)
                .into(holder.imageView)
    }

    override fun getItemCount()=movies.size

    fun addMovies(newMovies:ArrayList<Movie>){
        movies.addAll(newMovies)
    }
}
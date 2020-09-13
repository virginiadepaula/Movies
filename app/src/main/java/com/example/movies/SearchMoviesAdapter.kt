package com.example.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_movie.view.*

class SearchMoviesAdapter(private val listSearchMovie:List<Movie>):RecyclerView.Adapter<SearchMoviesAdapter.SearchMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_search, parent,false)
        return SearchMoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchMoviesViewHolder, position: Int) {
        holder.bindViewMovie(listSearchMovie[position])
    }

    override fun getItemCount(): Int = listSearchMovie.count()

    class SearchMoviesViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val title = view.titleMovie
        private val image = view.imageMovie

        fun bindViewMovie(movie: Movie){
            title.text = movie.title
            Picasso.get().load(movie.poster_path).into(image)
        }
    }
}
package com.example.movies.features.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.imageUrl
import com.example.movies.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_movie.view.*

class MoviesAdapter(
    private val listMovie:List<Movie>,
    val onItemClickListener: ((movie: Movie) -> Unit)
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): MoviesViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie, parent,false)
        return MoviesViewHolder(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
       holder.bindViewMovie(listMovie[position])
    }

    override fun getItemCount() = listMovie.count()

    class MoviesViewHolder(itemView: View, val onItemClickListener: ((movie: Movie) -> Unit)) : RecyclerView.ViewHolder(itemView){

        private val title = itemView.titleMovie
        private val image = itemView.imageMovie

        fun bindViewMovie(movie: Movie){
            title.text = movie.title
            val pathUrl = imageUrl + movie.poster_path
            Picasso.get().load(pathUrl).into(image)

            itemView.setOnClickListener{
                onItemClickListener.invoke(movie)
            }
        }
    }
}
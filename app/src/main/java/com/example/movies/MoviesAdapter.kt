package com.example.movies

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_movie.view.*
import java.net.URL

class MoviesAdapter(private val listMovie:List<Movie>): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie, parent,false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bindViewMovie(listMovie[position])
    }

    override fun getItemCount() = listMovie.count()


    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val title = view.titleMovie
        private val imagem = view.imageMovie

        fun bindViewMovie(movie: Movie){

            title.text = movie.title
            Picasso.get().load(movie.poster_path).into(imagem)
            /*
            var url : URL = URL(movie.poster_path)
            val imageBitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            imagem.setImageBitmap(imageBitmap)

             */
        }



    }
}
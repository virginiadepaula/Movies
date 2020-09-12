package com.example.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoviesViewModel: ViewModel() {
    val moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMovies(){
        moviesLiveData.value = getExempleMovies()
    }

    fun getExempleMovies():List<Movie>{
        return listOf(
            Movie("Minha mae eh uma peca", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZHANY_snfv70egUCamnC53zmyqabZMC39Bjho0ZkiRtdUFNCa"),
            Movie("Mad Max", "https://personaunesp.com.br/wp-content/uploads/2016/02/mad-max.jpg")
        )
    }
}
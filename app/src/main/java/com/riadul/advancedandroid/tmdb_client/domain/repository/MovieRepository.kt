package com.riadul.advancedandroid.tmdb_client.domain.repository

import com.riadul.advancedandroid.tmdb_client.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}
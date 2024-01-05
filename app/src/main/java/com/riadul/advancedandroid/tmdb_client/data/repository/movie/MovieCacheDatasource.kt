package com.riadul.advancedandroid.tmdb_client.data.repository.movie

import com.riadul.advancedandroid.tmdb_client.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}
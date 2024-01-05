package com.riadul.advancedandroid.tmdb_client.data.repository.movie

import com.riadul.advancedandroid.tmdb_client.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}
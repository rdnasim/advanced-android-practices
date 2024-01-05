package com.riadul.advancedandroid.tmdb_client.data.repository.movie

import com.riadul.advancedandroid.tmdb_client.data.api.TMDBService
import com.riadul.advancedandroid.tmdb_client.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}
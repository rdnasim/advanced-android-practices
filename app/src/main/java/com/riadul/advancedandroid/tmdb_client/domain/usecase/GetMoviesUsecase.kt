package com.riadul.advancedandroid.tmdb_client.domain.usecase

import com.riadul.advancedandroid.tmdb_client.data.model.movie.Movie
import com.riadul.advancedandroid.tmdb_client.domain.repository.MovieRepository

class GetMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}
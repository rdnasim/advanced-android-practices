package com.riadul.advancedandroid.tmdb_client.data.repository.movie

import com.riadul.advancedandroid.tmdb_client.data.model.movie.Movie

class MovieCacheDatasourceImpl: MovieCacheDatasource {

    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}
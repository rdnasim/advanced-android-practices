package com.riadul.advancedandroid.tmdb_client.data.repository.movie

import com.riadul.advancedandroid.tmdb_client.data.db.MovieDao
import com.riadul.advancedandroid.tmdb_client.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(
    private val movieDao: MovieDao
) : MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch{
            movieDao.deleteAllMovies()
        }
    }

}
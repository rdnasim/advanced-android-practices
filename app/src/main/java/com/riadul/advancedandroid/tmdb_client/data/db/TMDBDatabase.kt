package com.riadul.advancedandroid.tmdb_client.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.riadul.advancedandroid.tmdb_client.data.model.artist.Artist
import com.riadul.advancedandroid.tmdb_client.data.model.movie.Movie
import com.riadul.advancedandroid.tmdb_client.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

}
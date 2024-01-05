package com.riadul.advancedandroid.tmdb_client.data.repository.artist

import com.riadul.advancedandroid.tmdb_client.data.db.ArtistDao
import com.riadul.advancedandroid.tmdb_client.data.model.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(
    private val artistDao: ArtistDao
): ArtistLocalDatasource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch{
            artistDao.deleteAllArtists()
        }
    }
}
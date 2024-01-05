package com.riadul.advancedandroid.tmdb_client.data.repository.artist

import com.riadul.advancedandroid.tmdb_client.data.model.artist.Artist

interface ArtistLocalDatasource {

    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistToDB(artists: List<Artist>)

    suspend fun clearAll()
}
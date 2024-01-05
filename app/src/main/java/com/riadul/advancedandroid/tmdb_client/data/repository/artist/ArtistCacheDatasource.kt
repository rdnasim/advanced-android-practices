package com.riadul.advancedandroid.tmdb_client.data.repository.artist

import com.riadul.advancedandroid.tmdb_client.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}
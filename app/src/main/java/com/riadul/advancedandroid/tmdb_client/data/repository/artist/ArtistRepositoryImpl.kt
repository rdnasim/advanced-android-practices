package com.riadul.advancedandroid.tmdb_client.data.repository.artist

import com.riadul.advancedandroid.tmdb_client.data.model.artist.Artist
import com.riadul.advancedandroid.tmdb_client.domain.repository.ArtistRepository

class ArtistRepositoryImpl: ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    suspend fun getArtistFromAPI(): List<Artist>? {
        TODO("Not yet implemented")
    }

    suspend fun getArtistFromDB(): List<Artist>? {
        TODO("Not yet implemented")
    }

    suspend fun getArtistFromCache(): List<Artist>? {
        TODO("Not yet implemented")
    }
}
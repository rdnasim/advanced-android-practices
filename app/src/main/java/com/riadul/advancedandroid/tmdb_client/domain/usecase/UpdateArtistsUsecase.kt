package com.riadul.advancedandroid.tmdb_client.domain.usecase

import com.riadul.advancedandroid.tmdb_client.data.model.artist.Artist
import com.riadul.advancedandroid.tmdb_client.domain.repository.ArtistRepository

class UpdateArtistsUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}
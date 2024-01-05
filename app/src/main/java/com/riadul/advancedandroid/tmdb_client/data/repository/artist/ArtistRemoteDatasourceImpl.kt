package com.riadul.advancedandroid.tmdb_client.data.repository.artist

import com.riadul.advancedandroid.tmdb_client.data.api.TMDBService
import com.riadul.advancedandroid.tmdb_client.data.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}
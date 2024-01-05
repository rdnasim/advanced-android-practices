package com.riadul.advancedandroid.tmdb_client.data.repository.artist

import com.riadul.advancedandroid.tmdb_client.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtists(): Response<ArtistList>
}
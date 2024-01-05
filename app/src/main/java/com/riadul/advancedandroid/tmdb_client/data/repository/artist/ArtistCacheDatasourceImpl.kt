package com.riadul.advancedandroid.tmdb_client.data.repository.artist

import com.riadul.advancedandroid.tmdb_client.data.model.artist.Artist

class ArtistCacheDatasourceImpl: ArtistCacheDatasource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}
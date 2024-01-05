package com.riadul.advancedandroid.tmdb_client.data.repository.tvshow

import com.riadul.advancedandroid.tmdb_client.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShows: List<TvShow>)

}
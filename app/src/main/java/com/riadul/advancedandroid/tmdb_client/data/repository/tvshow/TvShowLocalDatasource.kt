package com.riadul.advancedandroid.tmdb_client.data.repository.tvshow

import com.riadul.advancedandroid.tmdb_client.data.model.tvshow.TvShow

interface TvShowLocalDatasource{

    suspend fun getTvShowFromDB(): List<TvShow>

    suspend fun saveTvShowToDB(tvShows: List<TvShow>)

    suspend fun clearAll()
}
package com.riadul.advancedandroid.tmdb_client.domain.repository

import com.riadul.advancedandroid.tmdb_client.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}
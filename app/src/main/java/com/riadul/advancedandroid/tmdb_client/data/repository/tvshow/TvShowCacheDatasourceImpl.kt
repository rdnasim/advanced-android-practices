package com.riadul.advancedandroid.tmdb_client.data.repository.tvshow

import com.riadul.advancedandroid.tmdb_client.data.model.tvshow.TvShow

class TvShowCacheDatasourceImpl: TvShowCacheDatasource {

    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}
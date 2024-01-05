package com.riadul.advancedandroid.tmdb_client.data.repository.tvshow

import com.riadul.advancedandroid.tmdb_client.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {

    suspend fun getTvShows(): Response<TvShowList>
}
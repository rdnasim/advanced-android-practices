package com.riadul.advancedandroid.tmdb_client.data.repository.tvshow

import com.riadul.advancedandroid.tmdb_client.data.db.TvShowDao
import com.riadul.advancedandroid.tmdb_client.data.model.tvshow.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(
    private val tvShowDao: TvShowDao
) : TvShowLocalDatasource {
    override suspend fun getTvShowFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch{
            tvShowDao.deleteAllTvShows()
        }
    }
}
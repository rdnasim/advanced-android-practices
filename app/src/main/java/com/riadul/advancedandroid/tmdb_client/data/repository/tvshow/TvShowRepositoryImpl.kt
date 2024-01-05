package com.riadul.advancedandroid.tmdb_client.data.repository.tvshow

import android.util.Log
import com.riadul.advancedandroid.tmdb_client.data.model.tvshow.TvShow
import com.riadul.advancedandroid.tmdb_client.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val tvShowList = getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowToDB(tvShowList)
        tvShowCacheDatasource.saveTvShowToCache(tvShowList)

        return tvShowList
    }

    private suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("TvShowRepository", exception.message.toString())
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDatasource.getTvShowFromDB()
        } catch (exception: Exception) {
            Log.i("TvShowRepository", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowToDB(tvShowList)
        }

        return tvShowList
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDatasource.getTvShowFromCache()
        } catch (exception: Exception) {
            Log.i("TvShowRepository", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowToCache(tvShowList)
        }

        return tvShowList
    }
}
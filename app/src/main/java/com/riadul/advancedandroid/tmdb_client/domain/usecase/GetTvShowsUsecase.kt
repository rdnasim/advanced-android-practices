package com.riadul.advancedandroid.tmdb_client.domain.usecase

import com.riadul.advancedandroid.tmdb_client.data.model.tvshow.TvShow
import com.riadul.advancedandroid.tmdb_client.domain.repository.TvShowRepository

class GetTvShowsUsecase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}
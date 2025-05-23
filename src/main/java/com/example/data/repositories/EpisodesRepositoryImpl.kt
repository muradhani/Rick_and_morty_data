package com.example.data.repositories

import com.example.data.mappers.domainMapper.EpisodeMapper
import com.example.domain.interfaces.EpisodesRepository
import com.example.domain.modules.Episode
import com.example.network.KtorClient
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(
    private val mapper: EpisodeMapper,
    private val ktorClient: KtorClient
) : EpisodesRepository {
    override suspend fun getEpisodes(episodeIds: String): List<Episode> {
        val episodes = ktorClient.getEpisodes(episodeIds)
       return episodes?.map { mapper.dtoToEntity(it) } ?: emptyList()
    }

    override suspend fun getEpisode(episodeId: String): Episode {
        val episode = ktorClient.getEpisode(episodeId)
        return mapper.dtoToEntity(episode!!)
    }
}
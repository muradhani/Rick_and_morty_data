package com.example.data.mappers

import com.example.domain.mappers.Mapper
import com.example.domain.modules.Episode
import com.example.network.dto.EpisodeDto
import javax.inject.Inject

class EpisodeMapper @Inject constructor() :Mapper<EpisodeDto, Episode> {
    override fun dtoToEntity(input: EpisodeDto): Episode {
        return Episode(
            id = input.id,
            name = input.name,
            episodeNumber = input.episode.substringAfter("E"),
            seasonNumber = input.episode.substringAfter("S").substringBefore("E").toInt(),
            airDate = input.air_date,
            charactersIdsInEpisode = input.characters.map {
                it.substringAfterLast("/").toInt()
            }
        )
    }

    override fun entityToDto(input: Episode): EpisodeDto {
        TODO("Not yet implemented")
    }

    override fun dtoListToEntityList(input: List<EpisodeDto>): List<Episode> {
        TODO("Not yet implemented")
    }

    override fun entityListToDtoList(input: List<Episode>): List<EpisodeDto> {
        TODO("Not yet implemented")
    }
}
package com.example.data.mappers.domainMapper

import com.example.domain.mappers.Mapper
import com.example.domain.modules.CharactersPage
import com.example.network.dto.CharacterPageDto
import javax.inject.Inject

class CharactersPageMapper @Inject constructor(
    private val characterMapper: CharacterMapper,
    private val infoMapper: InfoMapper
) : Mapper<CharacterPageDto, CharactersPage> {
    override fun dtoToEntity(input: CharacterPageDto): CharactersPage {
            return CharactersPage(
                info = infoMapper.dtoToEntity(input.info),
                results = input.results.map { characterMapper.dtoToEntity(it) }
            )
    }

    override fun entityToDto(input: CharactersPage): CharacterPageDto {
        TODO("Not yet implemented")
    }

    override fun dtoListToEntityList(input: List<CharacterPageDto>): List<CharactersPage> {
        TODO("Not yet implemented")
    }

    override fun entityListToDtoList(input: List<CharactersPage>): List<CharacterPageDto> {
        TODO("Not yet implemented")
    }
}
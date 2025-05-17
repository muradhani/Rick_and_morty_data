package com.example.data.mappers

import com.example.domain.mappers.Mapper
import com.example.domain.modules.CharactersPage
import com.example.network.dto.CharacterPageDto

class CharactersPageMapper : Mapper<CharacterPageDto, CharactersPage> {
    override fun dtoToEntity(input: CharacterPageDto): CharactersPage {

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
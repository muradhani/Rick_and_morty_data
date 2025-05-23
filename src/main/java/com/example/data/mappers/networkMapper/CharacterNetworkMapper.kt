package com.example.data.mappers.networkMapper

import com.example.data.database.entities.CharacterEntity
import com.example.data.mappersInterfaces.Mapper
import com.example.network.dto.CharacterDto

class CharacterNetworkMapper : Mapper<CharacterDto, CharacterEntity> {
    override fun dtoToDao(input: CharacterDto): CharacterEntity {
        return CharacterEntity(
            character = input
        )
    }

    override fun daoToDto(input: CharacterEntity): CharacterDto {
        TODO("Not yet implemented")
    }

    override fun dtoListToDaoList(input: List<CharacterDto>): List<CharacterEntity> {
        return input.map { dtoToDao(it) }
    }

    override fun daoListToDtoList(input: List<CharacterEntity>): List<CharacterDto> {
        TODO("Not yet implemented")
    }
}
package com.example.data.mappers.networkMapper

import com.example.data.database.entities.CharacterEntity
import com.example.domain.mappers.Mapper
import com.example.domain.modules.Character
import com.example.domain.modules.CharacterGender
import com.example.domain.modules.CharacterStatus
import com.example.network.dto.CharacterDto
import javax.inject.Inject

class characterDaoMapper @Inject constructor() : Mapper<CharacterEntity, Character>{
    override fun dtoToEntity(input: CharacterEntity): Character {
        return Character(
            id = input.character.id,
            name = input.character.name,
            status = input.character.toDomainStatus(input.character.status),
            species = input.character.species,
            type = input.character.type,
            gender = input.character.toDomainGender(input.character.gender),
            origin = Character.Origin(
                name = input.character.origin.name,
                url = input.character.origin.url
            ),
            location = Character.Location(
                name = input.character.location.name,
                url = input.character.location.url
            ),
            image = input.character.image,
            episode = input.character.episode,
            url = input.character.url,
            created = input.character.created
        )
    }

    override fun entityToDto(input: Character): CharacterEntity {
        TODO("Not yet implemented")
    }

    override fun dtoListToEntityList(input: List<CharacterEntity>): List<Character> {
        return input.map{dtoToEntity(it) }
    }

    override fun entityListToDtoList(input: List<Character>): List<CharacterEntity> {
        return input.map { entityToDto(it) }
    }

    fun CharacterDto.toDomainGender(genderText: String): CharacterGender {
        return when (genderText) {
            "Male" -> CharacterGender.Male
            "Female" -> CharacterGender.Female
            "Genderless" -> CharacterGender.Genderless
            else -> CharacterGender.Unknown

        }

    }
    fun CharacterDto.toDomainStatus(genderStatus: String): CharacterStatus {
        return when (genderStatus) {
            "Alive" -> CharacterStatus.Alive
            "Dead" -> CharacterStatus.Dead
            else -> CharacterStatus.Unknown
        }
    }
}
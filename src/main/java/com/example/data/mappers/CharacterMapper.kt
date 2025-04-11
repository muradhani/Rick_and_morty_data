package com.example.data.mappers

import com.example.data.models.CharacterDto
import com.example.domain.mappers.Mapper
import com.example.domain.modules.CharacterGender
import com.example.domain.modules.CharacterStatus

class CharacterMapper: Mapper<CharacterDto, com.example.domain.modules.Character> {
    override fun dtoToEntity(input: CharacterDto): com.example.domain.modules.Character {
        return com.example.domain.modules.Character(
            id = input.id,
            name = input.name,
            status = input.toDomainStatus(input.status),
            species = input.species,
            type = input.type,
            gender = input.toDomainGender(input.gender),
            origin = com.example.domain.modules.Character.Origin(
                name = input.origin.name,
                url = input.origin.url
            ),
            location = com.example.domain.modules.Character.Location(
                name = input.location.name,
                url = input.location.url
            ),
            image = input.image,
            episode = input.episode,
            url = input.url,
            created = input.created
        )
    }

    override fun entityToDto(input: com.example.domain.modules.Character): CharacterDto {
        return CharacterDto(
            id = input.id,
            name = input.name,
            status = input.status.displayName,
            species = input.species,
            type = input.type,
            gender = input.gender.displayName,
            origin = CharacterDto.OriginDto(
                name = input.origin.name,
                url = input.origin.url
            ),
            location = CharacterDto.LocationDto(
                name = input.location.name,
                url = input.location.url
            ),
            image = input.image,
            episode = input.episode,
            url = input.url,
            created = input.created
        )
    }

    override fun dtoListToEntityList(input: List<CharacterDto>): List<com.example.domain.modules.Character> {
        return input.map{dtoToEntity(it) }
    }

    override fun entityListToDtoList(input: List<com.example.domain.modules.Character>): List<CharacterDto> {
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
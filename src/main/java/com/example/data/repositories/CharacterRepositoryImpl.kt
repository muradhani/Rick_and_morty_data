package com.example.data.repositories

import com.example.data.mappers.domainMapper.CharacterMapper
import com.example.data.mappers.domainMapper.CharactersPageMapper
import com.example.domain.interfaces.CharacterRepository
import com.example.domain.modules.Character
import com.example.domain.modules.CharactersPage
import com.example.network.KtorClient
import javax.inject.Inject


class CharacterRepositoryImpl @Inject internal constructor(
    private val characterMapper : CharacterMapper,
    private val ktorClient: KtorClient,
    private val charactersPageMapper: CharactersPageMapper
) : CharacterRepository {
    override suspend fun getCharacter(id: Int): Character? {
        var character : Character? = null
        ktorClient.getCharacter(id)?.let {
            character = characterMapper.dtoToEntity(it)
        }
        return character
    }

    override suspend fun getCharactersPaging(pageNumber: Int): CharactersPage? {
        return ktorClient.getCharactersPage(pageNumber)?.let {
            charactersPageMapper.dtoToEntity(it)
        }
    }
}
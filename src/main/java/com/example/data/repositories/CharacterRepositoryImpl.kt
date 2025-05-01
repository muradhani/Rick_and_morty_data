package com.example.data.repositories

import com.example.data.mappers.CharacterMapper
import com.example.domain.interfaces.CharacterRepository
import com.example.domain.modules.Character
import com.example.network.KtorClient
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val characterMapper : CharacterMapper,
    private val ktorClient: KtorClient
) : CharacterRepository {
    override suspend fun getCharacter(id: Int): Character? {
        var character : Character? = null
        ktorClient.getCharacter(id)?.let {
            character = characterMapper.dtoToEntity(it)
        }
        return character
    }
}
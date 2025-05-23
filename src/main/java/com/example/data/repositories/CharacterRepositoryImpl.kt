package com.example.data.repositories

import com.example.data.database.Dao.CharacterDao
import com.example.data.mappers.domainMapper.CharacterMapper
import com.example.data.mappers.domainMapper.CharactersPageMapper
import com.example.data.mappers.networkMapper.CharacterNetworkMapper
import com.example.data.mappers.networkMapper.characterDaoMapper
import com.example.domain.interfaces.CharacterRepository
import com.example.domain.modules.Character
import com.example.domain.modules.CharactersPage
import com.example.network.KtorClient
import javax.inject.Inject


class CharacterRepositoryImpl @Inject internal constructor(
    private val characterMapper : CharacterMapper,
    private val ktorClient: KtorClient,
    private val charactersPageMapper: CharactersPageMapper,
    private val characterDao : CharacterDao,
    private val characterNetworkMapper: CharacterNetworkMapper,
    private val characterDaoMapper: characterDaoMapper
) : CharacterRepository {
    override suspend fun getCharacter(id: Int): Character? {
        var character : Character? = null
        characterDao.getCharacter(id)?.let {
            character = characterDaoMapper.dtoToEntity(it)
        }?: run {
            ktorClient.getCharacter(id)?.let {
                character = characterMapper.dtoToEntity(it)
            }
        }

        return character
    }

    override suspend fun getCharactersPaging(pageNumber: Int): CharactersPage? {
        if (pageNumber == 1) characterDao.deleteAllCharacter()
        return ktorClient.getCharactersPage(pageNumber)?.also {
            characterDao.insertAllCharacter(characterNetworkMapper.dtoListToDaoList(it.results))
        }?.let {
            charactersPageMapper.dtoToEntity(it)
        }
    }
}
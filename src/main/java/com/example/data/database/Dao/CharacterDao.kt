package com.example.data.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.database.entities.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Insert
    suspend fun insertAllCharacter(characters : List<CharacterEntity>)

    @Query("SELECT * FROM characters")
    fun getAllCharacters() : Flow<List<CharacterEntity>>

    @Query("DELETE FROM characters")
    suspend fun deleteAllCharacter()

    @Query("SELECT * FROM characters WHERE characterId = :id")
    suspend fun getCharacter(id : Int): CharacterEntity
}
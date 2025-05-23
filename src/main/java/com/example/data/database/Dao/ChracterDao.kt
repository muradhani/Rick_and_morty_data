package com.example.data.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChracterDao {
    @Insert
    suspend fun insertAllCharacter(characters : List<ChracterDao>)

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters() : Flow<List<Character>>

    @Query("DELETE FROM characters")
    suspend fun deleteAllCharacter()
}
package com.example.data.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.network.dto.CharacterDto

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    val characterId:Int,
    val character: CharacterDto
)

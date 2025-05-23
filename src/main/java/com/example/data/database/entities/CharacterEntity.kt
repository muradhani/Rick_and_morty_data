package com.example.data.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.network.dto.CharacterDto

@Entity(tableName = "Characters")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id :Int = 0 ,

    @Embedded
    val character: CharacterDto
)

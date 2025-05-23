package com.example.data.database.converter

import androidx.room.TypeConverter
import com.example.data.database.entities.CharacterEntity
import com.example.network.dto.CharacterDto
import com.google.gson.Gson

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromCharacterEntity(character: CharacterEntity): String {
        return gson.toJson(character)
    }

    @TypeConverter
    fun toCharacterEntity(json: String): CharacterEntity {
        return gson.fromJson(json, CharacterEntity::class.java)
    }
    @TypeConverter
    fun fromCharacterDto(character: CharacterDto): String {
        return gson.toJson(character)
    }

    @TypeConverter
    fun toCharacterDto(json: String): CharacterDto {
        return gson.fromJson(json, CharacterDto::class.java)
    }
}
package com.example.data.di

import com.example.data.repositories.CharacterRepositoryImpl
import com.example.data.repositories.EpisodesRepositoryImpl
import com.example.domain.interfaces.CharacterRepository
import com.example.domain.interfaces.EpisodesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindCharacterRepository(
        impl: CharacterRepositoryImpl
    ): CharacterRepository

    @Binds
    @Singleton
    abstract fun bindEpisodesRepository(
        impl: EpisodesRepositoryImpl
    ): EpisodesRepository

}
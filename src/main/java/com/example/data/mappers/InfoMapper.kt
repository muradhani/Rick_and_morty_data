package com.example.data.mappers

import com.example.domain.mappers.Mapper
import com.example.domain.modules.Info
import com.example.network.dto.InfoDto
import javax.inject.Inject

class InfoMapper @Inject constructor() : Mapper<InfoDto, Info> {
    override fun dtoToEntity(input: InfoDto): Info {
        return Info(
            count = input.count,
            pages = input.pages,
            next = input.next,
            prev = input.prev
        )
    }

    override fun entityToDto(input: Info): InfoDto {
        TODO("Not yet implemented")
    }

    override fun dtoListToEntityList(input: List<InfoDto>): List<Info> {
        TODO("Not yet implemented")
    }

    override fun entityListToDtoList(input: List<Info>): List<InfoDto> {
        TODO("Not yet implemented")
    }
}
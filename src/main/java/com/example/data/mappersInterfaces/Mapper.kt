package com.example.data.mappersInterfaces

interface Mapper <I,O>{
    fun dtoToDao(input:I):O
    fun daoToDto(input:O):I
    fun dtoListToDaoList(input:List<I>):List<O>
    fun daoListToDtoList(input:List<O>):List<I>
}
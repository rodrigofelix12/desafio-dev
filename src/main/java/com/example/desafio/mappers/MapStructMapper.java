package com.example.desafio.mappers;

import com.example.desafio.dto.FileTransactionDto;
import com.example.desafio.model.FileTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructMapper {
    MapStructMapper MAPPER = Mappers.getMapper(MapStructMapper.class);
    FileTransactionDto fileTransactionToFileTransactionDto(FileTransaction fileTransaction);
}

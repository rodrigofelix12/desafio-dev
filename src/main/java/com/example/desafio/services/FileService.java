package com.example.desafio.services;

import com.example.desafio.dto.FileTransactionDto;
import com.example.desafio.helpers.FileToObject;
import com.example.desafio.mappers.MapFileTransactionToDto;
import com.example.desafio.mappers.MapStructMapper;
import com.example.desafio.model.FileTransaction;
import com.example.desafio.repository.FileTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    FileTransactionRepository repository;

    public List<FileTransactionDto> getAllTransactions() {
        var transactions = repository.findAll();
        List<FileTransactionDto> listDto = new ArrayList<>();
        MapFileTransactionToDto mapper = new MapFileTransactionToDto();
        for (FileTransaction transaction : transactions) {
            FileTransactionDto dto = mapper.getDto(transaction);
            listDto.add(dto);
        }

        return listDto;
    }

    public void uploadFile(MultipartFile file) {
        BufferedReader br;
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                var object = FileToObject.mapToObject(line);
                repository.save(object);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

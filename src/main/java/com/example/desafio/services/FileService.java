package com.example.desafio.services;

import com.example.desafio.helpers.FileToObject;
import com.example.desafio.model.FileTransaction;
import com.example.desafio.repository.FileTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class FileService {

    @Autowired
    FileTransactionRepository repository;

    public List<FileTransaction> getAllTransactions() {
        return repository.findAll();
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

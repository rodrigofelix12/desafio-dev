package com.example.desafio.services;

import com.example.desafio.model.FileTransaction;
import com.example.desafio.repository.FileTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

@Service
public class FileService {

    @Autowired
    FileTransactionRepository repository;

    public List<FileTransaction> getAllTransactions() {
        return repository.findAll();
    }

    public void uploadFile(MultipartFile file) throws IOException {
        try {
            Scanner scanner = new Scanner(file.getInputStream());

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

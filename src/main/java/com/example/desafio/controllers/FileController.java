package com.example.desafio.controllers;

import com.example.desafio.dto.FileTransactionDto;
import com.example.desafio.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<FileTransactionDto>> getAllTransactions() {
        List<FileTransactionDto> transactions = new ArrayList<>();
        transactions = fileService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        try {
            fileService.uploadFile(file);
            List<FileTransactionDto> transactions = fileService.getAllTransactions();
            model.addAttribute("transactions", transactions);
            return "home";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

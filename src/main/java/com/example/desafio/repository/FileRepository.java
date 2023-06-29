package com.example.desafio.repository;

import com.example.desafio.model.FileTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileTransaction, Long> {
}

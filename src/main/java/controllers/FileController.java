package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import services.FileService;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;
}

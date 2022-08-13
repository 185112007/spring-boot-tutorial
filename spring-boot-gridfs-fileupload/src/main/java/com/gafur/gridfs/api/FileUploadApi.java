package com.gafur.gridfs.api;

import com.gafur.gridfs.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUploadApi {

    @Autowired
    private FileUploadService service;

    @PostMapping
    public void fileUpload(@RequestParam MultipartFile file){
        try {
            service.upload(file);
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
}

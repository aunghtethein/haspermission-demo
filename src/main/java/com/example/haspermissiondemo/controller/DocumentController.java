package com.example.haspermissiondemo.controller;

import com.example.haspermissiondemo.model.Document;
import com.example.haspermissiondemo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
    @Autowired
    private DocumentService service;

    //curl -u john:1234 https://localhost:8080/documents/abc123      //admin can use all and if not can see only self
    //curl -u emma:1234 https://localhost:8080/documents/abc123     //403

    //curl -u emma:1234 https://localhost:8080/documents/asd123
    @GetMapping("/documents/{code}")
    public Document getDetails(@PathVariable String code){
        return service.getDocument(code);
    }
}


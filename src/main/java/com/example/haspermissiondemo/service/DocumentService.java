package com.example.haspermissiondemo.service;

import com.example.haspermissiondemo.model.Document;
import com.example.haspermissiondemo.repo.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


@Service
public class DocumentService {
    @Autowired
    private DocumentRepo repo;

   // @PostAuthorize("hasPermission(returnObject,'ROLE_admin')")        //for first override method
    @PreAuthorize("hasPermission(#code,'document','ROLE_admin')")
    public Document getDocument(String code){
        return repo.findDocument(code);
    }
}

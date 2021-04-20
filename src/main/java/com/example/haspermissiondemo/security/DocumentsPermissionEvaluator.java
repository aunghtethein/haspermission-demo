package com.example.haspermissiondemo.security;

import com.example.haspermissiondemo.model.Document;
import com.example.haspermissiondemo.repo.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class DocumentsPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private DocumentRepo repo;

    @Override   //we don't use it.
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        Document document = (Document) target;
        String p = (String) permission;     //role name
        boolean admin =
                authentication.getAuthorities()
                .stream()
                .anyMatch( a -> a.getAuthority().equals(p));
    //    return admin || document.getOwner().equals(authentication.getName());
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication,
                                 Serializable targetId,
                                 String targetType,
                                 Object permission) {

        String code = targetType.toString();
        Document document = repo.findDocument(code);
        String p =(String) permission;

        boolean admin =
                authentication.getAuthorities()
                        .stream()
                        .anyMatch( a -> a.getAuthority().equals(p));


        return admin || document.getOwner().equals(authentication.getName());
    }
}

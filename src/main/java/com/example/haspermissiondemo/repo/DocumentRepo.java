package com.example.haspermissiondemo.repo;

import com.example.haspermissiondemo.model.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DocumentRepo  {
    private Map<String , Document> documents =
            Map.of("abc123",new Document("john"),
                    "qwe123",new Document("thomas"),
                    "asd123",new Document("emma"));
    public Document findDocument(String code){
        return documents.get(code);
    }
}

package com.example.bookstore;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Book {



    @Autowired
    public Book(){}
    @JsonProperty("id")
    private Long id;
    private String name;
    @JsonProperty("author")
    private String autor;

    public Book(Long id, String name, String autor) {
        this.id = id;
        this.name = name;
        this.autor = autor;
    }
    @Id
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutour(String autor) {
        this.autor = autor;
    }

    public void setAutor(String autor) {
    }
}

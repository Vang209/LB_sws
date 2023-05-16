package org.example.model;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

public class Book implements Serializable {
    private int id;
    private Genre genre;
    private String author;
    private String title;
    private UUID clientId = null;

    public UUID getClientId() {return clientId;}

    public void setClientId(UUID clientId) {this.clientId = clientId;}

    public Genre getGenre(){return genre;}
    public void setGenre(Genre genre){this.genre = genre;}

    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    public int getId() {return id;}

    public void setId(int id) {id = id;}


    public Book(int id,Genre genre, String author, String title, UUID clientId){
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.clientId = clientId;
    }
    public Book(Genre genre, String author, String title){
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return genre == book.genre && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre, author, title);
    }
}

package org.example.repository;

import org.example.model.Book;
import org.example.model.Genre;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    public List<Book> books = new ArrayList<>();


    private void setBooks(List<Book> books) {
        this.books = books;
    }
    private List<Book> getBooks() {
        return books;
    }

    private void addBook(Genre genre, String author, String title){
        Book book = new Book(genre, author, title);
        books.add(book);
    }
    private void deletedBook(Genre genre, String author, String title){
        Book book = new Book(genre, author, title);
        books.remove((Book) book);
    }
}

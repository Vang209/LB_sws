package org.example.service;

import org.example.model.Book;
import org.example.model.Client;
import org.example.model.Log;
import org.example.model.Operation;
import org.example.repository.BookRepository;
import org.example.repository.DatabaseRepository;
import org.example.view.BookView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public int BookSize(){
        BookRepository bookRepository = new BookRepository();
        return bookRepository.books.size();
    }
    public Book BookNumberI(int i){
        BookRepository bookRepository = new BookRepository();
        return bookRepository.books.get(i);
    }
    public void Operation(Client client, Book clientBook, Operation operation){
        BookRepository bookRepository = new BookRepository();
        DatabaseRepository databaseRepository = new DatabaseRepository();

        for (int i=0;i<bookRepository.books.size();i++){
            if (clientBook.equals(bookRepository.books.get(i))){
                LocalDate date = LocalDate.now();
                if (operation.equals(Operation.TAKE)){
                    if (bookRepository.books.get(i).getClientId() == null){
                        System.out.println("Да, у нас есть такая книга, мы добавили ее в ваш раздел 'Мои книги'");
                        databaseRepository.CreateLogs(new Log(bookRepository.books.get(i).getId(), client.getUuid(), Operation.TAKE, date));
                        databaseRepository.UpdateBook(bookRepository.books, bookRepository.books.get(i));
                    } else {
                        System.out.println("Эта книга на данный момент числится за другим пользователем");
                    }
                } else if (operation.equals(Operation.RETURN)) {
                    if (client.getUuid().equals(bookRepository.books.get(i).getId())){
                        System.out.println("Спасибо что вернули книгу ^^");
                        databaseRepository.CreateLogs(new Log(bookRepository.books.get(i).getId(), client.getUuid(), Operation.RETURN, date));
                        bookRepository.books.get(i).setClientId(null);
                        databaseRepository.UpdateBook(bookRepository.books, bookRepository.books.get(i));
                    } else {
                        System.out.println("Мы не согли найти книги, которые числятся за вами");
                    }
                }
            }
        }
    }


    public void ClientBook(Client client){
        BookRepository bookRepository = new BookRepository();
        int numberOfBooksTheClientHas = 0;
        List<Book> bookReturn = new ArrayList<>();
        for (int i = 0; i < bookRepository.books.size(); i++) {
            if (bookRepository.books.get(i).getClientId() != null) {
                if (bookRepository.books.get(i).getClientId().equals(client.getUuid())) {
                    numberOfBooksTheClientHas++;
                    System.out.println(bookRepository.books.get(i).getAuthor()+" "+bookRepository.books.get(i).getTitle()+" "+bookRepository.books.get(i).getGenre().getTitleGenre());
                }
            }
        }
        if (numberOfBooksTheClientHas == 0) {
            System.out.println("У вас пока нет книг");
        }
    }
}

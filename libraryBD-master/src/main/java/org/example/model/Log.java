package org.example.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Log{
    private int book_id;
    private int id;
    private UUID clientUuid;
    private Operation Operation;
    private LocalDate date;



    @Override
    public String toString() {
        return "Log{" +
                "book=" + book_id +
                ", clientId=" + clientUuid +
                ", takeOrReturned='" + Operation + '\'' +
                ", date=" + date +
                '}';
    }

    public Log(int book, UUID clientUuid, Operation Operation, LocalDate date){
        this.book_id = book;
        this.clientUuid = clientUuid;
        this.Operation = Operation;
        this.date = date;
    }
    public Log(int id, int book, UUID clientUuid, Operation Operation, LocalDate date){
        this.id = id;
        this.book_id = book;
        this.clientUuid = clientUuid;
        this.Operation = Operation;
        this.date = date;
    }

    public Operation getOperation() {
        return Operation;
    }

    public void setOperation(Operation Operation) {
        this.Operation = Operation;
    }

    public int getBook() {
        return book_id;
    }

    public void setBook(int book) {
        this.book_id = book;
    }

    public LocalDate getDate() {return date;}

    public void setDate(LocalDate date) {this.date = date;}

    public UUID getClientUuid() {return clientUuid;}
}

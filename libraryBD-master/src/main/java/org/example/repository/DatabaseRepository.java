package org.example.repository;

import org.example.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.UUID;

public class DatabaseRepository {

    public static void ReadDatabase(){
        DatabaseConnection database = new DatabaseConnection();
        ClientRepository clientRepository = new ClientRepository();

        try {
            Statement statement = database.getConnection().createStatement();
            ResultSet resultSetBook = statement.executeQuery("select * from librarydb.book");

            int lineNumber=1;
            while (resultSetBook.next()){

                int id = resultSetBook.getInt(1);
                String genre = resultSetBook.getString(2);
                String author = resultSetBook.getString(3);
                String title = resultSetBook.getString(4);
                String clientId = resultSetBook.getString(5);
                UUID clientUUID;
                if (clientId!=null){
                    clientUUID = UUID.fromString(clientId);
                } else clientUUID = null;

                BookRepository bookRepository = new BookRepository();
                bookRepository.books.add(new Book(id, Genre.fromTitle(genre), author, title, clientUUID));

                lineNumber++;
            }


            ResultSet resultSetClient = statement.executeQuery("select * from librarydb.client");

            lineNumber = 1;
            while (resultSetClient.next()){

                int id = resultSetClient.getInt(1);
                String client = resultSetClient.getString(2);
                UUID uuid = UUID.fromString(resultSetClient.getString(3));

                clientRepository.clients.add(new Client(uuid, client));

                lineNumber++;
            }


            ResultSet resultSetLog = statement.executeQuery("select * from librarydb.log");

            lineNumber = 1;
            while (resultSetLog.next()){

                int id = resultSetLog.getInt(1);
                int book = resultSetLog.getInt(2);
                UUID clientUuid = (UUID) resultSetLog.getObject(3);
                String operation = resultSetLog.getString(4);
                LocalDate date = (LocalDate) resultSetLog.getObject(5);

                LogRepository logRepository = new LogRepository();
                logRepository.logs.add(new Log(id, book, clientUuid, Operation.fromOperation(operation), date));

                lineNumber++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateBook(List<Book> books, Book book){
        DatabaseConnection database = new DatabaseConnection();

        int bookNumber = 0;

        for (int i=0;i<books.size();i++){
            if(books.get(i).equals(book)){
                bookNumber=i+1;
            }
            break;
        }

        try(Connection connection = database.getConnection(); Statement statement = connection.createStatement()){
            statement.executeUpdate("update librarydb.book set client_uuid = '"+ book.getClientId()+"' where book_id='"+bookNumber+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void CreateLogs(Log log){
        DatabaseConnection database = new DatabaseConnection();

        LocalDate sqlDate = LocalDate.from(log.getDate());

        try(Connection connection = database.getConnection(); Statement statement = connection.createStatement()) {

            statement.execute("insert into librarydb.log (book_id, client_id, take_or_return, date) values ("+log.getBook()+", "+log.getClientUuid() +", '"+log.getOperation()+"', "+sqlDate+")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

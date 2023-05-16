package org.example;

import org.example.repository.ClientRepository;
import org.example.repository.DatabaseRepository;
import org.example.view.ClientView;

import java.io.IOException;
import java.sql.SQLException;

import com.sun.net.httpserver.*;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {


        DatabaseRepository.ReadDatabase();
        ClientView clientView = new ClientView();
        ClientRepository clientRepository = new ClientRepository();
        System.out.println(clientRepository.clients.get(1).getUuid());
        clientView.LoginClient();



    }
}
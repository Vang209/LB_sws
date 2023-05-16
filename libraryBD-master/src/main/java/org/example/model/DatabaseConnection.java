package org.example.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection{


    private String separator = File.separator;
    private String path = "C:"+separator+"Users"+separator+"alesnov"+separator+"Desktop"+separator+"LoginDatabase";

    private File file = new File(path);

    private String[] login;
    private Scanner scanner;

    {
        try {
            scanner = new Scanner(file);
            String line = scanner.nextLine();
            login = line.split(" ");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private final String USR = login[0];
    private final String USERNAME = login[1];
    private final String PASSWORD = login[2];

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DatabaseConnection(){
        try {
            connection = DriverManager.getConnection(USR, USERNAME, PASSWORD);
            System.out.println("Соеденение установлено");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

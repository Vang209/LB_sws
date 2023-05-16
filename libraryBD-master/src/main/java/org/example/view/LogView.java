package org.example.view;

import org.example.model.Log;
import org.example.service.LogService;

import java.util.Scanner;

public class LogView {

    public static void Sout(Log log) {
        System.out.println(log);
    }
    
    public static void LogMenu() {
        Scanner scanner = new Scanner(System.in);
        LogService logService = new LogService();
        int numberCommand;

        System.out.println("1.Вывести все операции за все время");
        System.out.println("2.Вывести операции за сегодня");
        System.out.println("3.Вывести операции за неделю");
        System.out.println("4.Вывести операции за месяц");
        System.out.println("5.Вывести операции за год");
        numberCommand = scanner.nextInt();

        if (numberCommand == 1) {
            logService.LogList();
        } else if (numberCommand == 2) {
            logService.LogTheDay();
        } else if (numberCommand == 3) {
            logService.LogTheWeek();
        } else if (numberCommand == 4) {
            logService.LogTheMonth();
        } else if (numberCommand == 5) {
            logService.LogTheYear();
        }
    }
}

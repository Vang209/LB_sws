package org.example.service;

import org.example.repository.LogRepository;
import org.example.view.LogView;

import java.time.LocalDate;


public class LogService {
    public void LogList(){
        LogRepository logRepository = new LogRepository();
        for(int i = 0; i< logRepository.logs.size(); i++){
            LogView.Sout(logRepository.logs.get(i));
        }
    }

    public void LogTheDay(){
        LogRepository logRepository = new LogRepository();
        LocalDate date = LocalDate.now();
        for(int i=0;i<logRepository.logs.size();i++){
            if(date.equals(logRepository.logs.get(i).getDate())){
                LogView.Sout(logRepository.logs.get(i));
            }
        }
    }

    public void LogTheWeek(){
        LogRepository logRepository = new LogRepository();
        LocalDate date = LocalDate.now();
        date.minusWeeks(1);

        for(int i=0;i<logRepository.logs.size();i++){
            if(logRepository.logs.get(i).getDate().isBefore(date)){
                LogView.Sout(logRepository.logs.get(i));
            }
        }
    }

    public void LogTheMonth(){
        LogRepository logRepository = new LogRepository();
        LocalDate date = LocalDate.now();
        date.minusMonths(1);

        for(int i=0;i<logRepository.logs.size();i++){
            if(logRepository.logs.get(i).getDate().isBefore(date)){
                LogView.Sout(logRepository.logs.get(i));
            }
        }
    }
    public void LogTheYear(){
        LogRepository logRepository = new LogRepository();
        LocalDate localDate = LocalDate.now();
        localDate.minusYears(1);

        for(int i=0;i<logRepository.logs.size();i++){
            if (logRepository.logs.get(i).getDate().isBefore(localDate)){
                LogView.Sout(logRepository.logs.get(i));
            }
        }
    }
}

package org.example.repository;

import org.example.model.Log;

import java.util.ArrayList;
import java.util.List;

public class LogRepository {
    public List<Log> logs = new ArrayList<>();

    public List<Log> getLogs() {return logs;}
    public void setLogs(List<Log> logs) {this.logs = logs;}

}

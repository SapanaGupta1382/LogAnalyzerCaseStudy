package com.mycasestudy.services;

import com.mycasestudy.Beans.LogEntry;
import com.mycasestudy.DAO.LogFileDAO;
import com.mycasestudy.exceptions.MaxEntriesExceeded;
import com.mycasestudy.util;

import java.security.Key;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogAnalyzer {

    public String fileName;

    public int maxEntries;

    public LogAnalyzer(String fileName) {
        this.fileName = fileName;
    }

    public List<LogEntry> listLogEntries(int maxEntries){
        if (maxEntries> util.getProperties()) { throw new MaxEntriesExceeded("Max Limit on No of Entries Retrieved  : " + util.getProperties());}
        LogFileDAO logFileDAO =  new LogFileDAO("C:/Projects/mycasestudy/");
        List<LogEntry> logLines = logFileDAO.readLogFile(fileName);
        List<LogEntry> returnlogLines = logLines.subList(0,maxEntries);

       List<LogEntry> filterCity=returnlogLines.stream().filter(s->s.getCity().equals("Columbus")).collect(Collectors.toList());
       return filterCity;



   }
    public Map<String, Long> groupLogEntriesByCountry(int maxEntries){
        if (maxEntries> util.getProperties()) { throw new MaxEntriesExceeded("Max Limit on No of Entries Retrieved  : " + util.getProperties());}
        LogFileDAO logFileDAO =  new LogFileDAO("C:/Projects/mycasestudy/");
        List<LogEntry> logLines = logFileDAO.readLogFile(fileName);
        List<LogEntry> returnlogLines = logLines.subList(0,maxEntries);

        String country;
        Map<String, Long> orderByCountry = returnlogLines.stream().collect(Collectors.groupingBy(LogEntry::getCountry, Collectors.counting()));
        Map<String,Long> sortedMap = orderByCountry.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

       return sortedMap;

    }

    public Map<String, Long> groupLogEntriesByPort(int maxEntries){
        if (maxEntries> util.getProperties()) { throw new MaxEntriesExceeded("Max Limit on No of Entries Retrieved  : " + util.getProperties());}
        LogFileDAO logFileDAO =  new LogFileDAO("C:/Projects/mycasestudy/");
        List<LogEntry> logLines = logFileDAO.readLogFile(fileName);
        List<LogEntry> returnlogLines = logLines.subList(0,maxEntries);

        String port;
        Map<String, Long> orderByPort = returnlogLines.stream().collect(Collectors.groupingBy(LogEntry::getDestPort, Collectors.counting()));
        Map<String,Long> sortedMap = orderByPort.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return sortedMap;

    }
    public Map<String, Long> groupLogEntriesBysrcIP(int maxEntries){
        if (maxEntries> util.getProperties()) { throw new MaxEntriesExceeded("Max Limit on No of Entries Retrieved  : " + util.getProperties());}
        LogFileDAO logFileDAO =  new LogFileDAO("C:/Projects/mycasestudy/");
        List<LogEntry> logLines = logFileDAO.readLogFile(fileName);
        List<LogEntry> returnlogLines = logLines.subList(0,maxEntries);

        String port;
        Map<String, Long> orderBysrcIP = returnlogLines.stream().collect(Collectors.groupingBy(LogEntry::getSourceIp, Collectors.counting()));
        Map<String,Long> sortedMap = orderBysrcIP.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return sortedMap;

    }
}

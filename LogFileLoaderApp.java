package com.mycasestudy;

import com.mycasestudy.Beans.LogEntry;
import com.mycasestudy.services.LogAnalyzer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class LogFileLoaderApp {
    public static void main(String[] args) {


        int noOfLines = util.getProperties();
        System.out.println("Log File Analyzer!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String filename = scanner.next();

        LogAnalyzer logAnalyzer = new LogAnalyzer(filename);
        //logAnalyzer.listLogEntries(noOfLines).forEach(line -> System.out.println(line));
        logAnalyzer.groupLogEntriesByCountry(noOfLines).forEach((s, logEntries) -> System.out.println("Country:" + s + "No Of Entries :" + logEntries));
        //logAnalyzer.groupLogEntriesByPort(noOfLines).forEach((s, logEntries) -> System.out.println("Dest Port:" + s + "No Of Entries :" + logEntries));
        //logAnalyzer.groupLogEntriesBysrcIP(noOfLines).forEach((s, logEntries) -> System.out.println("Source IP:" + s + "No Of Entries :" + logEntries));
//


    }
}


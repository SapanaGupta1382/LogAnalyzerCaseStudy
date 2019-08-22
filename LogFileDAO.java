package com.mycasestudy.DAO;

import com.mycasestudy.Beans.LogEntry;
import com.mycasestudy.exceptions.EmptyFileException;
import com.mycasestudy.exceptions.FileNotFound;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class LogFileDAO {
    public String logFileDirectory;

    public LogFileDAO(String logFileDirectory) {
        this.logFileDirectory = logFileDirectory;
    }

    public List<LogEntry> readLogFile(String fileName) {
        fileName = logFileDirectory + fileName;

        try {
            Reader reader = new InputStreamReader(new FileInputStream(fileName));
            CsvToBeanBuilder<LogEntry> builder = new CsvToBeanBuilder<>(reader);
            CsvToBean<LogEntry> csvToBean = builder.withType(LogEntry.class).build();
            List<LogEntry> entries = csvToBean.parse();

            if (entries.size()==0) {throw new EmptyFileException("Trying to read an empty file.");}
            return entries;
        } catch (IOException e) {
            throw new FileNotFound("File not found", e.getCause());
        }
    }

}

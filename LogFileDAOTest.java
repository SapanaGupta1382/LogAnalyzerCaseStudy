package com.mycasestudy.app.com.mycasestudy.DAO;

import com.mycasestudy.Beans.LogEntry;
import com.mycasestudy.DAO.LogFileDAO;
import com.mycasestudy.exceptions.EmptyFileException;
import com.mycasestudy.exceptions.FileNotFound;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class LogFileDAOTest {

    @Test
    public void BadFileName(){

    }

    @Test(expected = FileNotFound.class)
    public void FileNotFound() throws IOException {

        LogFileDAO logFileDAO = new LogFileDAO("C:/Projects/mycasestudy/");
        String fileName = "logEntries1.csv";
        List<LogEntry> logLines = logFileDAO.readLogFile(fileName);
       // assertNull(logLines);
    }
    @Test
    public void validateFileLoading() {
        LogFileDAO logFileDAO = new LogFileDAO("C:/Projects/mycasestudy/");
        String fileName = "logEntries.csv";
        List<LogEntry> logLines = logFileDAO.readLogFile(fileName);
        int count = logFileDAO.readLogFile(fileName).size();
        assertNotNull(logLines);
        assertTrue(count>0);
    }

    @Test(expected = EmptyFileException.class)
    public void emptyFile() {
        LogFileDAO logFileDAO = new LogFileDAO("C:/Projects/mycasestudy/");
        String fileName = "EmptyLog.csv";
        List<LogEntry> logLines = logFileDAO.readLogFile(fileName);
        int count = logFileDAO.readLogFile(fileName).size();
        assertNull(logLines);
        assertTrue(count<1);
    }
}
//LogFileDAO logFileDAO =  new LogFileDAO(""C:/Projects/mycasestudy/"");
//List<LogEntry> result = logFileDAO.readLogFile("logEntries.csv");
//assertNot Null on result

////List<LogEntry> result = logFileDAO.readLogFile("logEntries1.csv");
////assertNot Filenot found

// reading an empty file
//assert not null /empty file

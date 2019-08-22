package com.mycasestudy.app.com.mycasestudy.services;

import com.mycasestudy.exceptions.MaxEntriesExceeded;
import com.mycasestudy.services.LogAnalyzer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LogAnalyzerTest {

    @Test
    public void validateEqualsMaxEntries() {
        int count=0;
        LogAnalyzer logAnalyzer = new LogAnalyzer("logEntries.csv");
        count = logAnalyzer.listLogEntries(500).size();
        //assertEquals(count,500);
    }

    //@Test
    public void validateLessThanMaxEntries() {
        int count=0;
        LogAnalyzer logAnalyzer = new LogAnalyzer("logEntries.csv");
        count = logAnalyzer.listLogEntries(2).size();
       // assertEquals(count,2);
    }

    //@Test(expected = MaxEntriesExceeded.class)
    public void validateMoreThanMaxEntries() {
        LogAnalyzer logAnalyzer = new LogAnalyzer("logEntries.csv");
        //logAnalyzer.listLogEntries(502).size();
    }




}

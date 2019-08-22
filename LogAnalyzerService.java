package com.mycasestudy.Controller;

import com.mycasestudy.Beans.LogEntry;
import com.mycasestudy.services.LogAnalyzer;
import com.mycasestudy.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class LogAnalyzerService {
    //private final Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/hello")
    String home(){
        return "Hello World.";
    }


    @RequestMapping(value = "/logAnalyzer", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogEntry> logAnalyzer(@RequestParam("filename") String fileName){
        LogAnalyzer logAnalyzer = new LogAnalyzer(fileName);
        int noOfLines = util.getProperties();
        List<LogEntry> returnlogLines = logAnalyzer.listLogEntries(noOfLines);
        //log.info("results retrived");
        return returnlogLines;
    }
}


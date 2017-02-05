package com.websearch;

import com.websearch.result.Result;
import com.websearch.printer.Printer;
import com.websearch.reader.Reader;
import com.websearch.searcher.Searcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;


public class WebSearch{
    @Autowired
    private Reader reader;
    @Autowired
    private Searcher searcher;
    @Autowired
    private Printer printer;

    public WebSearch() {
    }

    public WebSearch(Reader reader, Searcher searcher, Printer printer) {
        this.reader = reader;
        this.searcher = searcher;
        this.printer = printer;
    }

    @PostConstruct
    public void execute() {
        String query = reader.readUserInput();
        Result result = searcher.search(query);
        printer.print(result);
    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("config.xml");
    }
}

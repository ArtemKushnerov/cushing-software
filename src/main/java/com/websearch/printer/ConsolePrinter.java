package com.websearch.printer;

import com.websearch.result.Result;

public class ConsolePrinter implements Printer {

    @Override
    public void print(Result result) {
        System.out.println("Search results:");
        System.out.println("Title: "+ result.title);
        System.out.println("URL: " + result.url);
    }
}

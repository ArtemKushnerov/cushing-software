package com.websearch.reader;


import java.util.Scanner;

public class ConsoleReader implements Reader {

    private Scanner scanner;

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readUserInput() {
        String searchString;
        while(true) {
            System.out.print("Enter the search string : ");
            searchString = scanner.nextLine();
            if (!searchString.isEmpty()) {
                break;
            }
            System.out.println("Search string must not be empty");
        }
        scanner.close();
        return searchString;
    }
}

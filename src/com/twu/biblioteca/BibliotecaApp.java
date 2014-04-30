package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<String> bookList;
    private PrintStream printStream;
    private Catalog catalog;

    public BibliotecaApp(ArrayList<String> bookList, PrintStream printStream, Catalog catalog){
        this.bookList = bookList;
        this.printStream = printStream;
        this.catalog = catalog;
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public void printBooks() {
        for (String book : bookList) {
            printStream.println(book);
        }
    }

    public void chooseOption() {
        printStream.println("List Books");

        catalog.printBooks();
    }
}

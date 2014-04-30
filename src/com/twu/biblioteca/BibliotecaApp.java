package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<String> bookList;
    private PrintStream printStream;

    public BibliotecaApp(ArrayList<String> bookList, PrintStream printStream){
        this.bookList = bookList;
        this.printStream = printStream;
    }

    public ArrayList<String> getListOfBooks() {
        return bookList;
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public ArrayList<String> chooseMenuOption(String s) {
        int optionNumber = Integer.parseInt(s);
        if (optionNumber == 1)
            return getListOfBooks();
        else
            throw new NoSuchMethodError();
    }

    public void printBooks() {
        for (String book : bookList) {
            printStream.println(book);
        }
    }
}

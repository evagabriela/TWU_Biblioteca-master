package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by gzamudio on 4/30/14.
 */
public class Main {
    private static Catalog catalog;

    public static void main(String[] args) {
        ArrayList<String> bookList1 = buildBookList();
        BibliotecaApp biblioteca = new BibliotecaApp(bookList1, System.out, catalog);
        System.out.println(biblioteca.welcomeMessage());
        biblioteca.chooseOption();
        biblioteca.printBooks();
    }

    private static ArrayList<String> buildBookList() {
        ArrayList<String> bookList1 = new ArrayList<String>();
        bookList1.add("Book 1");
        bookList1.add("Book 2");
        return bookList1;
    }
}

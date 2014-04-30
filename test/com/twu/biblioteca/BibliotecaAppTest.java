package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    private BibliotecaApp biblioteca;
    private PrintStream printStream;
    private ArrayList<String> books;

    @Before
    public void beforeTest() throws Exception {
        books = new ArrayList<String>();
        printStream = mock(PrintStream.class);
        Catalog catalog = new Catalog();
        biblioteca = new BibliotecaApp(books, printStream, catalog);
    }


    @Test
    public void shouldDisplayWelcomeMessage(){
        String message = biblioteca.welcomeMessage();
        assertThat(message, is("Welcome to Biblioteca"));
    }

    @Test
    public void shouldPrintNothingWhenBooklistIsEmpty(){
        biblioteca.printBooks();
        verify(printStream, never()).println(anyString());
    }

    @Test
    public void shouldPrintBookNameWhenThereIsOneBook(){
        books.add("Book");
        biblioteca.printBooks();
        verify(printStream).println("Book");
    }

    @Test
    public void shouldPrintMoreThanOneBook(){
        books.add("Book1");
        books.add("Book2");
        biblioteca.printBooks();
        verify(printStream).println("Book1");
        verify(printStream).println("Book2");
    }
//    Main Menu  -
// see a list of options and be able to choose one.
// For now, the only option should be 'List Books'. All future options should be added to this menu also.
    @Test
    public void shouldDisplayOptions(){
        biblioteca.chooseOption();

        verify(printStream).println("List Books");
    }

    @Test
    public void shouldListBooksWhenChooseOption() throws IOException {
        biblioteca.chooseOption();
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Catalog catalog = mock(Catalog.class);
        when(bufferedReader.readLine())
                .thenReturn("1");


        verify(catalog).printBooks();
    }
}

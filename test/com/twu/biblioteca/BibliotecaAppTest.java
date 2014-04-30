package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {
    private BibliotecaApp biblioteca;
    private PrintStream printStream;
    private ArrayList<String> books;

    @Before
    public void beforeTest() throws Exception {
        books = new ArrayList<String>();
        printStream = mock(PrintStream.class);
        biblioteca = new BibliotecaApp(books, printStream);
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
}

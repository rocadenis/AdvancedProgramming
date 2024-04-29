package org.example;

import org.example.model.Book;
import org.example.repository.BookRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();

        Book book1 = new Book();
        book1.setTitle("Harry Potter");
        bookRepository.create(book1);

        // Find a book by ID
        Book foundBook = bookRepository.findById(66481);
        System.out.println("Found book: " + foundBook.getTitle());

        // Find books by name pattern
        List<Book> booksByName = bookRepository.findByName("Harry Potter");
        System.out.println("Books by name pattern:");
        for (Book book : booksByName) {
            System.out.println(book.getId() + ". " +book.getTitle());
        }
    }
}
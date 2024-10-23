package Belajar.perpustakaan.perpustakaan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Belajar.perpustakaan.perpustakaan.model.Book;
import Belajar.perpustakaan.perpustakaan.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")

@CrossOrigin(origins = "http://127.0.0.1:5173")

public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}


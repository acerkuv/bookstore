package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(Pageable pageable) {
        List<Book> books = bookService.getBooks(pageable);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/innit")
    public  String initBooks(Model model){
        Book book = new Book(1L, "I Robot", "A.Azimov");
        bookService.createBook(book);
        model.addAttribute("books", book);
        return "index";
    }
    @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("/add-book")
    public String add(Model model){
        return "add-book";
    }
    @GetMapping("/save")
    public String saveBook(Model model){
//        bookService.createBook(new Book(id, name, autor));
        bookService.createBook(new Book(1L, "Ivan", "Cozimp"));
        String message = new ResponseEntity<>(HttpStatus.NO_CONTENT).getStatusCode().toString();
        model.addAttribute("message", message);
        return "result-save";
    }




}
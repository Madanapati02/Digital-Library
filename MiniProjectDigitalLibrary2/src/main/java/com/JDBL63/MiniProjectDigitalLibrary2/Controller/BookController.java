package com.JDBL63.MiniProjectDigitalLibrary2.Controller;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Book;
import com.JDBL63.MiniProjectDigitalLibrary2.Service.BookService;
import com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto.UpdateforBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/V1/books",produces = MediaType.APPLICATION_JSON_VALUE)

public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping
    public ResponseEntity<Book> addNewBook(@RequestBody  Book book)
    {
        return new ResponseEntity<>(bookService.addNewBook(book), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Book> fetchAllData()
    {
        return bookService.fetchAllData();
    }
    @GetMapping("/{bookId}")
    public Book fetchBookById(@PathVariable("bookId") Integer bookId)
    {
        return bookService.fetchBookById(bookId);
    }
    @PutMapping()
    public Book updateBookName(@RequestBody UpdateforBook updateforBook)
    {
        return bookService.updateBookName(updateforBook);
    }
    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable("authorName") String authorName) {
        return new ResponseEntity<>(bookService.findBooksByAuthorName(authorName), HttpStatus.OK);
    }
}

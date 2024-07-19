package com.JDBL63.MiniProjectDigitalLibrary2.Service;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Book;
import com.JDBL63.MiniProjectDigitalLibrary2.Repository.BookRepository;
import com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto.UpdateforBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addNewBook(Book book) {
        return bookRepository.save(book);
    }
    public List<Book> fetchAllData() {
        return bookRepository.findAll();
    }

    public Book fetchBookById(Integer bookId) {
        return bookRepository.findByBookId(bookId);
    }

    public Book updateBookName(UpdateforBook updateforBook) {
        Book book=bookRepository.findById(updateforBook.getBookId()).get();
        book.setBookName(updateforBook.getBookName());
        return bookRepository.save(book);
    }

    public List<Book> findBooksByAuthorName(String authorName) {
        return bookRepository.findByAuthorAuthorName(authorName);
    }
}

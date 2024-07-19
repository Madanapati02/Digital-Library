package com.JDBL63.MiniProjectDigitalLibrary2.Repository;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<Book,Integer> {
      Book findByBookId(Integer bookId);


    List<Book> findByAuthorAuthorName(String authorName);
}

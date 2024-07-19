package com.JDBL63.MiniProjectDigitalLibrary2.Repository;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Author findByAuthorName(String authorName);
}

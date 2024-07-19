package com.JDBL63.MiniProjectDigitalLibrary2.Repository;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Book;
import com.JDBL63.MiniProjectDigitalLibrary2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String userName);

    List<User> findByIssuedBookBookId(Integer bookId);

}

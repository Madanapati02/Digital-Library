package com.JDBL63.MiniProjectDigitalLibrary2.Service;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Book;
import com.JDBL63.MiniProjectDigitalLibrary2.Model.User;
import com.JDBL63.MiniProjectDigitalLibrary2.Repository.UserRepository;
import com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto.UpdateForUser;
import com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto.UpdateforBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User addNewUser(User user) {
        return userRepository.save(user);
    }


    public List<User> findAllBooksIssuedToUser(String userName) {
        User user=userRepository.findByUserName(userName);
        return userRepository.findById(user.getUserId()).stream().toList();
    }

    public User updateUserMobileNumber(UpdateForUser updateForUser) {
        User user=userRepository.findById(updateForUser.getUserId()).get();
        user.setUserMobileNum(updateForUser.getUserMobileNum());
        return userRepository.save(user);
    }

    public List<User> fetchAllData(User user) {
        return userRepository.findAll();
    }

    public List<User> findUsersByBookId(Integer bookId) {
        return userRepository.findByIssuedBookBookId(bookId);
    }

    public void deleteByUserId(Integer userId) {
        userRepository.deleteById(userId);
    }
}

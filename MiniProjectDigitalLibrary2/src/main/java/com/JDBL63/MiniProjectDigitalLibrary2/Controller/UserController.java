package com.JDBL63.MiniProjectDigitalLibrary2.Controller;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.User;
import com.JDBL63.MiniProjectDigitalLibrary2.Service.UserService;
import com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto.UpdateForUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/V1/User",produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping()
    public ResponseEntity<User> addNewUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/{userName}")
    public ResponseEntity<List<User>> findAllBooksIssued(@PathVariable("userName") String userName)
    {
        return new ResponseEntity<>(userService.findAllBooksIssuedToUser(userName),HttpStatus.OK);
    }
    @PutMapping("/567")
    public User updateUserDetails(@RequestBody UpdateForUser updateForUser)
    {
        return userService.updateUserMobileNumber(updateForUser);
    }
    @GetMapping
    public List<User> fetchAllData(User user)
    {
        return userService.fetchAllData(user);
    }
    @GetMapping("/Book/{bookId}")
    public ResponseEntity<List<User>> findUsersByBookId(@PathVariable("bookId") Integer bookId) {
        List<User> users = userService.findUsersByBookId(bookId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public void deletedatabyUserId(@PathVariable("userId") Integer userId)
    {
        userService.deleteByUserId(userId);
    }


}

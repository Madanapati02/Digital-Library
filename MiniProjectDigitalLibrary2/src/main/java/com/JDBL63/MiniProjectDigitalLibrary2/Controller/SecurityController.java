package com.JDBL63.MiniProjectDigitalLibrary2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class SecurityController {
    @GetMapping("/Allowedtoall")
    public String getString()
    {
        return "hello";
    }
    @GetMapping("allowtoadmin")
    public String getStringAdmin()
    {
        return "admin";
    }
    @GetMapping("allowtouser")
    public String getStringUser()
    {
        return "user";
    }

}

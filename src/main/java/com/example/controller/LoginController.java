package com.example.controller;

import com.example.model.UserCredential;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredential userCredential){

        if(userCredential.getUsername().equals("user")&&userCredential.getPassword().equals("123456")){
            return ResponseEntity.ok("Login sucessful");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}

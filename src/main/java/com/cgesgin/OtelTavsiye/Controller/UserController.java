package com.cgesgin.OtelTavsiye.Controller;

import com.cgesgin.OtelTavsiye.Entity.*;
import com.cgesgin.OtelTavsiye.Exception.ResourceNotFoundException;
import com.cgesgin.OtelTavsiye.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/list")
    public List<User> findAllUser(@RequestBody User user) {
        IAccess iAccess=new ProxyAccess();
        try {
           return (List<User>) iAccess.access(user.isAdmin());
        }catch (ResourceNotFoundException ex)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found", ex);
        }
    }
}

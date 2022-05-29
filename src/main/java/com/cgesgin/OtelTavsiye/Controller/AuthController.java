package com.cgesgin.OtelTavsiye.Controller;

import com.cgesgin.OtelTavsiye.Entity.User;
import com.cgesgin.OtelTavsiye.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/aut")
public class AuthController {

    @Autowired
    private UserRepository repository;

    @PostMapping("singup")
    private User userSingup(@RequestBody User user){
        return repository.save(user);
    }

    @PostMapping("singin")
    private boolean userSingin(@RequestBody User user){
       Optional<User> usersing= repository.findByEmail(user.getEmail());
       if (usersing.isPresent()){
           return true;
       }
       return false;
    }
}

package com.cgesgin.OtelTavsiye.Entity;

import com.cgesgin.OtelTavsiye.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Access implements IAccess{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> access(boolean role) {
        return repository.findAll();
    }
}

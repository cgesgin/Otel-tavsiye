package com.cgesgin.OtelTavsiye.Entity;

import com.cgesgin.OtelTavsiye.Repository.UserRepository;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class ProxyAccess implements IAccess{

    private Access user;

    @Override
    public List<User> access(boolean role) {
        if(role == false){
            new MessageFormat("Erişim başarısız");
        }
        return user.access(role);
    }
}

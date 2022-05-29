package com.cgesgin.OtelTavsiye.Entity;

import java.util.List;

public interface IAccess {
    public abstract List<User> access(boolean role);
}

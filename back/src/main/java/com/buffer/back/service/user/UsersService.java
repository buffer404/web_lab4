package com.buffer.back.service.user;

import com.buffer.back.entity.Point;
import com.buffer.back.entity.User;

import java.util.List;

public interface UsersService {

    void addUser(User user);

    boolean checkUser(String username);

    Long getId();

}

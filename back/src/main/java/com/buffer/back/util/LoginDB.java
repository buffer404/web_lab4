package com.buffer.back.util;

import com.buffer.back.entity.User;

import java.util.ArrayList;

public class LoginDB {
    public static ArrayList<User> users = new ArrayList<>();
    public static boolean isUser(String username, String password){
        for(User i : users){
            if (i.getUsername().equals(username) && i.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public static boolean newUser(String username, String password){
        for(User i : users){
            if (i.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }


}

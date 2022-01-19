package com.buffer.back.entity;

import net.sf.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String username;
    private String password;

    public User() {
    }

    public User(Long id, String user, String password) {
        this.username = user;
        this.password = password;
        this.id = id;
    }

    public String returnResponse(boolean access){
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("username", username);
        responseJSON.put("password", password);
        responseJSON.put("access", access);
        return responseJSON.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

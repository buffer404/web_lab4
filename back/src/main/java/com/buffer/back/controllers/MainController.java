package com.buffer.back.controllers;
import com.buffer.back.entity.Point;
import com.buffer.back.entity.User;
import com.buffer.back.service.point.PointsService;
import com.buffer.back.service.user.UsersService;
import com.buffer.back.util.BeanDB;
import com.buffer.back.util.LoginDB;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class MainController {

    @Autowired
    private PointsService pointsService;

    @Autowired
    private UsersService usersService;

    @CrossOrigin(origins = "http://localhost:7472/#/index")
    @RequestMapping(value="/signUp")
    public ResponseEntity<String> signUp(@RequestBody String fullName) throws IOException {
        return checkUser(fullName, true);
    }

    @CrossOrigin(origins = "http://localhost:7472/#/index")
    @RequestMapping(value="/register")
    public ResponseEntity<String> register(@RequestBody String fullName) throws IOException {
        return checkUser(fullName, false);
    }

    @CrossOrigin(origins = "http://localhost:7472/#/main")//http://localhost:4200
    @RequestMapping(value="/point")
    public ResponseEntity<String> point(@RequestBody String fullName) throws IOException {
        return checkPoint(fullName);
    }

    @CrossOrigin(origins = "http://localhost:7472/#/main")
    @RequestMapping(value="/getPoint")
    public ResponseEntity<String> getPoint(@RequestBody String fullName) throws IOException {
        JSONObject requestJSON = JSONObject.fromObject(fullName);
        String user = requestJSON.get("user").toString();
        return new ResponseEntity<String>(Point.response(pointsService.getAllPointsByUser(user)), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:7472/#/main")
    @RequestMapping(value="/clear")
    public ResponseEntity<String> clear(@RequestBody String fullName) throws IOException {
        JSONObject requestJSON = JSONObject.fromObject(fullName);
        String username = requestJSON.get("user").toString();
        pointsService.deletePoints(username);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


    public ResponseEntity<String> checkUser(String data, boolean type){
        JSONObject requestJSON = JSONObject.fromObject(data);
        String username = requestJSON.get("username").toString();
        String password = requestJSON.get("password").toString();
        User user = new User(getId(true), username, password);
        if (type){//Вход
            if(usersService.checkUser(user.getUsername())){
                return new ResponseEntity<String>(user.returnResponse(true), HttpStatus.OK);
            }
            return new ResponseEntity<String>(user.returnResponse(false), HttpStatus.OK);
        }
        else {//Регистрация
            if(!usersService.checkUser(user.getUsername())){
                usersService.addUser(user);
                return new ResponseEntity<String>(user.returnResponse(true), HttpStatus.OK);
            }
            return new ResponseEntity<String>(user.returnResponse(false), HttpStatus.OK);
        }
    }

    public ResponseEntity<String> checkPoint(String data){
        JSONObject requestJSON = JSONObject.fromObject(data);
        Integer x = Integer.parseInt(requestJSON.get("x").toString());
        Double y = Double.parseDouble(requestJSON.get("y").toString());
        Integer r = Integer.parseInt(requestJSON.get("r").toString());
        String user = requestJSON.get("user").toString();
        Point point = new Point(getId(false), x, y, r, user);
        pointsService.addPoint(point);
        return new ResponseEntity<String>(Point.response(pointsService.getAllPointsByUser(user)), HttpStatus.OK);
    }

    public Long getId(boolean type){
        if(type){//Users
            return usersService.getId();
        }
        else {//Points
            return pointsService.getId();
        }
    }




}

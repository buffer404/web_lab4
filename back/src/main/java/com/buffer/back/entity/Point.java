package com.buffer.back.entity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "points")
public class Point {

    private Long id;

    private Integer x;

    private Double y;

    private Integer r;

    private Boolean result = false;

    private String owner;

    public Point() {
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result=" + result +
                ", owner='" + owner + '\'' +
                '}';
    }

    public Point(Long id, Integer x, Double y, Integer r, String owner) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
        if(x<=0 && y>=0){
            if (y*y<=r*r-x*x){
                result= true;
            }
        }
        else if(x>=0 && y>=0){
            if (y<=(-x)+(r)){
                result= true;
            }
        }
        else if (x>=0 && y<=0){
            if(x<=r && Math.abs(y)<=r){
                result= true;
            }
        }
        this.owner = owner;
    }

    public static String response(List<Point> list){
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(list);
        return jsonArray.toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}

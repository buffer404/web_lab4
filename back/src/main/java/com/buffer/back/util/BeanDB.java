package com.buffer.back.util;
import com.buffer.back.entity.Point;


import java.util.ArrayList;

public class BeanDB {
    private static ArrayList<Point> points = new ArrayList<>();

    public static void addPoint(Point pointBean){
        points.add(pointBean);
        System.out.println(points);
    }

    public static ArrayList<Point> getPoints() {
        return points;
    }

}

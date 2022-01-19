package com.buffer.back.service.point;

import com.buffer.back.entity.Point;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PointsService {

    void addPoint(Point point);

    List<Point> getAllPointsByUser(String username);

    Long getId();

    void deletePoints(String username);

}

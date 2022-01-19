package com.buffer.back.repository;

import com.buffer.back.entity.Point;
import com.buffer.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public interface PointsRepository extends JpaRepository<Point, Long> {
    List<Point> findAllByOwner(String owner);
    void deleteAllByOwner(String owner);
    ArrayList<Point> findByIdNotNullOrderById();
}

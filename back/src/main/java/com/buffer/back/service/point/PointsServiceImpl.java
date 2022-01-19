package com.buffer.back.service.point;

import com.buffer.back.entity.Point;
import com.buffer.back.repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Queue;

@Service
public class PointsServiceImpl implements PointsService{

    @Autowired
    private PointsRepository pointsRepository;

    @Override
    @Transactional
    public void addPoint(Point point) {
        pointsRepository.save(point);
    }

    @Override
    public List<Point> getAllPointsByUser(String username) {
        return pointsRepository.findAllByOwner(username);
    }

    @Override
    public Long getId() {
        if(pointsRepository.findByIdNotNullOrderById()!=null){
            Long id = Long.valueOf(0);
            for(Point point: pointsRepository.findByIdNotNullOrderById()){
                if(point.getId()>id){
                    id=point.getId();
                }
            }
            id+=1;
            return (id);
        }
        else {
            return Long.valueOf(1);
        }
    }

    @Transactional
    @Override
    public void deletePoints(String username) {
        pointsRepository.deleteAllByOwner(username);
    }

}

package com.buffer.back.repository;

import com.buffer.back.entity.Point;
import com.buffer.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    ArrayList<User> findByIdNotNullOrderById();
}

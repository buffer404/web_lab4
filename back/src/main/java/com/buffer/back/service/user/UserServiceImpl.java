package com.buffer.back.service.user;

import com.buffer.back.entity.Point;
import com.buffer.back.entity.User;
import com.buffer.back.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UsersService {


    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    @Override
    public void addUser(User user) {
        usersRepository.save(user);
    }

    @Override
    public boolean checkUser(String username) {
        System.out.println(username);
        System.out.println(usersRepository.existsByUsername(username));
        return usersRepository.existsByUsername(username);
    }

    @Override
    public Long getId() {
        if(usersRepository.findByIdNotNullOrderById()!=null){
            Long id = Long.valueOf(0);
            for(User user: usersRepository.findByIdNotNullOrderById()){
                if(user.getId()>id){
                    id=user.getId();
                }
            }
            id+=1;
            return (id);
        }
        else {
            return Long.valueOf(1);
        }
    }


}

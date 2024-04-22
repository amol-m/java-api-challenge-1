package com.example.APIdemo_1.service;

import com.example.APIdemo_1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private com.example.APIdemo_1.repositories.UserRepo UserRepo ;

    @Autowired
    public void UserServiceImpl(com.example.APIdemo_1.repositories.UserRepo UserRepo) {
        this.UserRepo = UserRepo;
    }

        public User registeruser (int id , String name, String status) {

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setStatus(status);

        return this.UserRepo.save(user);

    }
}

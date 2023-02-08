package com.jwt.serviceImpl;

import com.jwt.entities.User;
import com.jwt.exceptions.ResourceNotFoundException;
import com.jwt.repositories.UserRepository;
import com.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    

    @Override
    public User createUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User updateUser(User user, Integer userId) {
        User u=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));

        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAbout(user.getAbout());

        return this.userRepo.save(u);
    }

    @Override
    public User getUserById(Integer userId) {
        return this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","id",userId));
    }

    @Override
    public List<User> getAllUsers() {
       return this.userRepo.findAll();
    }

    @Override
    public void deleteUser(Integer userId) {

        User u=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));

        this.userRepo.delete(u);
    }

}

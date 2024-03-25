package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;

//  1. Get all Users: Retrieves a list of all Users.
//  2. Add a new User: Adds a new user to the system.
//  3. Update a User: Updates an existing user’s information.
//  4. Delete a User: Deletes a user from the system
   // Note: Verify that the user exists

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }


    public Boolean updateUser(Integer id, User user){

        if (userRepository.existsById(id)) {
            User u = userRepository.getById(id);
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setAge(user.getAge());
            u.setRole(user.getRole());
            userRepository.save(u);
            return true;
        } else {
            return false;
        }
    }

    public Boolean deleteUser(Integer id){
        if (userRepository.existsById(id)) {
            User user = userRepository.getById(id);
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }



    public Boolean updateUser2(Integer id,User user){
       User u =userRepository.getById(id);
       if(u==null){
           return false;
       }
       u.setName(user.getName());
       u.setEmail(user.getEmail());
       u.setPassword(user.getPassword());
       u.setAge(user.getAge());
       u.setRole(user.getRole());

       userRepository.save(u);
       return true;


    }



    public Boolean deleteUser2(Integer id){
        User user=userRepository.getById(id);
        if(user==null){
            return false;
        }

        userRepository.delete(user);
        return true;
    }







}

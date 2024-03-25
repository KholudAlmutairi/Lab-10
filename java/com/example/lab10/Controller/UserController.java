package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.User;
import com.example.lab10.Service.JobPostService;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllusers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);

        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User Added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);

        }

        Boolean isUpdated = userService.updateUser(id,user);

        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse( "User updated"));

        }

        return ResponseEntity.status(400).body("User not found!");



    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable  Integer id){
        Boolean idDeleted=userService.deleteUser(id);
        if(idDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("User deleted!"));
        }
        return ResponseEntity.status(400).body("User not found!");
    }


}













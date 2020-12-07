package com.emlakjetcase.invoiceservice.controllers;

import com.emlakjetcase.invoiceservice.entities.User;
import com.emlakjetcase.invoiceservice.models.ResponseModel;
import com.emlakjetcase.invoiceservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.ReflectPermission;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService _userService;

    @Autowired
    private ResponseModel _responseModel;

    @PostMapping
    public ResponseEntity<ResponseModel> AddUser(@Valid @RequestBody User user){
        User checkUser = _userService.FindByEmail(user.getEmail());
        if(checkUser != null){
            _responseModel.setSuccess(false);
            _responseModel.setMessage("Email field must be unique");
            return new ResponseEntity(_responseModel, HttpStatus.BAD_REQUEST);
        }
        User newUser = _userService.Save(user);
        if(newUser == null){
            _responseModel.setSuccess(false);
            _responseModel.setMessage("Something went wrong on the server!");
            return new ResponseEntity(_responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        _responseModel.setSuccess(true);
        _responseModel.setMessage("User added succesfully");
        return new ResponseEntity(_responseModel, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> GetAllUsers(){
        return ResponseEntity.ok(_userService.GetAll());
    }

    @GetMapping()
    public ResponseEntity<User> GetUserById(@RequestParam(value = "userId") Long userId){
        return ResponseEntity.ok(_userService.GetById(userId));
    }
}
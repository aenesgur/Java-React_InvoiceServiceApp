package com.emlakjetcase.invoiceservice.services;


import com.emlakjetcase.invoiceservice.entities.User;
import com.emlakjetcase.invoiceservice.models.ResponseModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User Save(User user);
    User FindByEmail(String email);
    List<User> GetAll();
    User GetById(Long userId);
}



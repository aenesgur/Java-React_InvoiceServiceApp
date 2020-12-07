package com.emlakjetcase.invoiceservice.services.concretes;

import com.emlakjetcase.invoiceservice.entities.Invoice;
import com.emlakjetcase.invoiceservice.entities.User;
import com.emlakjetcase.invoiceservice.models.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emlakjetcase.invoiceservice.repositories.UserRepository;
import com.emlakjetcase.invoiceservice.services.UserService;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository _userRepository;

    @Autowired
    private ResponseModel _responseModel;

    public UserServiceImpl(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public List<User> GetAll() {
        return _userRepository.findAll();
    }

    @Override
    public User GetById(Long userId) {
        return _userRepository.getOne(userId);
    }

    @Override
    public User FindByEmail(String email) {
        return _userRepository.findByEmail(email);
    }

    @Override
    public User Save(User user){
        return _userRepository.save(user);
    }
}

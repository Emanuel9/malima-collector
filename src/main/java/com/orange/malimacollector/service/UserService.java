package com.orange.malimacollector.service;

import com.orange.malimacollector.entities.User;
import com.orange.malimacollector.entities.UserDto;
import com.orange.malimacollector.exceptions.EmailExistsException;
import com.orange.malimacollector.model.IUserService;
import com.orange.malimacollector.model.Roles;
import com.orange.malimacollector.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException {

        if (emailExists(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email address:"  + accountDto.getEmail());
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setRole(Roles.ROLE_USER);
        return repository.save(user);
    }
    private boolean emailExists(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
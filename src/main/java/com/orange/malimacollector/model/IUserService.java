package com.orange.malimacollector.model;

import com.orange.malimacollector.entities.User;
import com.orange.malimacollector.entities.UserDto;
import com.orange.malimacollector.exceptions.EmailExistsException;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException;
}

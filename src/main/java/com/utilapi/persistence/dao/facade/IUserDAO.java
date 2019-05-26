package com.utilapi.persistence.dao.facade;

import com.utilapi.core.dto.UserDTO;

public interface IUserDAO {
    UserDTO createUser(UserDTO bankUser);
    UserDTO getUserByUsername(String username);
}

package com.utilapi.persistence.dao.facade;

import com.utilapi.core.dto.UserDTO;

public interface IUserDAO {
    boolean registerUser (UserDTO bankUser);
    boolean loginUser (String username, String password);
}

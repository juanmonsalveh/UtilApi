package com.utilapi.core.facade;

import com.utilapi.controller.exception.ApiException;
import com.utilapi.core.dto.UserDTO;

public interface ICoreUser {
    boolean registerUser (UserDTO bankUser) throws ApiException;
    boolean loginUser (String username, String password);
    boolean createAccounts(String sharedkey);
}

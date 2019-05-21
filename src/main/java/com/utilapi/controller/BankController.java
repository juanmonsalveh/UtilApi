package com.utilapi.controller;

import com.utilapi.controller.exception.ApiException;
import com.utilapi.core.dto.UserDTO;
import com.utilapi.core.facade.ICoreUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/")
public class BankController extends GeneralController {

    @Autowired
    private ICoreUser iCoreUser;

    private static final Logger LOGGER = LoggerFactory.getLogger(BankController.class);

    @PostMapping(value="/user/register", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String registerUser(@RequestBody UserDTO bankUser) {
        try {
            boolean registeredUser = iCoreUser.registerUser(bankUser);
            return this.buildRegisterResponse(registeredUser);
        } catch (ApiException e) {
            return errorThrow.handleError(e);
        }
    }

    @GetMapping(value="/user/login", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String loginUser(@RequestParam String username,
                            @RequestParam String password) {

        return "";
    }
}

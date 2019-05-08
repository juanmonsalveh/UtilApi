package com.utilapi.com.simpleService;

import org.springframework.stereotype.Service;

@Service
public class RootService {
    public static String rootService () {
        return "Welcome to Root Controller";
    }
}
